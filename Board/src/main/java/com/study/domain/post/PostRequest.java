package com.study.domain.post;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PostRequest {
	private Long id;
	private String title;
	private String content;
	private String writer;
	private Boolean notice_yn;
}
