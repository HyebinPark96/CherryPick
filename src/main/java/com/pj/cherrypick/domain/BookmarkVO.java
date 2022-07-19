package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Builder
public class BookmarkVO {
	
	private int bmkc_no;
	private int cno;
	private String username;
	private Integer chk;
}
