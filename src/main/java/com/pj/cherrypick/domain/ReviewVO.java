package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Builder
public class ReviewVO {

	private int rno;
	private String mid;
	private int cno;
	private String date;
	private String title;
	private String content;
	private int score;
	private int waiting;
}
