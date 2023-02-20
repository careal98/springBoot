package com.study.domain.post;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.common.dto.SearchDto;

@Mapper
public interface PostMapper {
	
	/** 게시글 저장 **/
	void save(PostRequest params);
	
	/** 게시글 리스트 조회 **/
	List<PostResponse> findAll(SearchDto params);
	
	/** 게시글 수 카운팅 **/
	int count(SearchDto params);
	
	/** 게시글 상세 정보 조회(아이디) **/
	PostResponse findById(Long id);
	
	/** 게시글 수정 **/
	void update(PostRequest parmas);
	
	void deleteById(Long id);
}
