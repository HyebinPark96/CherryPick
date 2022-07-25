package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Builder
public class ListVO {
	
	private int lino;
	private String username;
	private String liname;
	private int li_cafe1;
	private int li_cafe2;
	private int li_cafe3;
	private int li_cafe4;
	private int li_cafe5;
	
	// 즐겨찾기 확인용
	private Integer chk;
	
	// 썸네일 띄우기
	private Integer cno;
	private String cimage;

}
