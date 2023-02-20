package com.study;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.domain.post.PostMapper;
import com.study.domain.post.PostRequest;
import com.study.domain.post.PostResponse;

import net.bytebuddy.description.modifier.ParameterManifestation;

@SpringBootTest
public class PostMapperTest {
	@Autowired
	PostMapper postMapper;
	
	@Test
	void save() {
		PostRequest params = new PostRequest(); 
		params.setTitle("1번 게시글 제목");
		params.setContent("1번 게시글 내용");
		params.setWriter("tester");
		params.setNotice_yn(false);
		postMapper.save(params);
		
		List<PostResponse> posts = postMapper.findAll();
		System.out.println("전체 게시글 개수는: " + posts.size());
	}
}
