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
	
	// 귀찮으니까 리스트 북마크랑 카페 북마크랑 둘 다 이거 씀
	
	private int bmkc_no; 
	private int bmkli_no;
	private int cno; 
	private int lino;
	private String username;
	private Integer chk;
}
