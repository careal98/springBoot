package com.study.domain.post;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class PostResponse {
	private Long id;
	private String title;
	private String content;
	private String writer;
	private int view_cnt;
	private Boolean notice_yn;
	private Boolean delete_yn;
	private LocalDateTime created_date;
	private LocalDateTime modified_date;
}
