package com.study.domain.post;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.common.dto.MessageDto;
import com.study.common.dto.SearchDto;
import com.study.paging.PagingResponse;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
 
	private final PostService postService;
	
	@GetMapping("/post/write.do")
	public String openPostWrite(@RequestParam(value="id", required = false) final Long id, Model model) {
		if(id != null) {
			PostResponse post = postService.findPostById(id);
			model.addAttribute("post", post);
		}
		return "post/write";
	}
	
	@PostMapping("/post/save.do")
	public String savePost(PostRequest params, Model model) {
		postService.savePost(params);
	    System.out.println("savePost: " + params);
	    MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
		return showMessaeAndRedirect(message, model);
	}
	
	@GetMapping("/post/list.do")
	public String openPostList(@ModelAttribute("params") final SearchDto params, Model model) {
		PagingResponse<PostResponse> list = postService.openPostList(params);
		System.out.println("list:" + list);
		model.addAttribute("list", list);
		return "post/list";
	}
	
	@GetMapping("/post/view.do")
	public String openPostView(@RequestParam final Long id, Model model) {
		PostResponse post = postService.findPostById(id);
		System.out.println("viewPost: " + post);
		model.addAttribute("post", post);
		return "post/view";
	}
	
	@PostMapping("/post/update.do")
	public String updatePost(PostRequest params, Model model) {
		postService.updatePost(params);
		MessageDto message = new MessageDto("게시글 수정이 완료되었습니다", "/post/list.do", RequestMethod.GET, null);
		return showMessaeAndRedirect(message, model);
	}
	
	@PostMapping("/post/delete.do")
	public String deletePost(Long id, Model model) {
		System.out.println("id:" + id);
		postService.deleteById(id);
		MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다", "/post/list.do", RequestMethod.GET, null);
		return showMessaeAndRedirect(message, model);
	}
	
	private String showMessaeAndRedirect(final MessageDto params, Model model) {
		model.addAttribute("params", params);
		return "common/messageRedirect";
	}
}
