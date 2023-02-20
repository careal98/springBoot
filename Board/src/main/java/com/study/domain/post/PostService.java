package com.study.domain.post;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.dto.SearchDto;
import com.study.paging.Pagination;
import com.study.paging.PagingResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostMapper postMapper;
	
	@Transactional
	public Long savePost(final PostRequest params) {
		postMapper.save(params);
		return params.getId();
	}
	
	public PagingResponse<PostResponse> openPostList(final SearchDto params){
		int count = postMapper.count(params);
		if(count < 1) {
			return new PagingResponse<>(Collections.emptyList(), null);
		}
		Pagination pagination = new Pagination(count, params);
		params.setPagination(pagination);
		
		List<PostResponse> list = postMapper.findAll(params);
		return new PagingResponse<>(list, pagination);
	}
	
	public PostResponse findPostById(Long id) {
		return postMapper.findById(id);
	}
		
	@Transactional
	public Long updatePost(PostRequest params) {
		postMapper.update(params);
		return params.getId();
	}
	
	public Long deleteById(Long id) {
		postMapper.deleteById(id);
		return id;
	}
}
