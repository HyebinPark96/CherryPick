package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Builder
public class FilterVO {
	
	//필터링용
	private Integer fpark;
	private Integer fpet;
	private Integer fkids;
	private Integer fgroup;
	private Integer sort;

	//페이징, 개수
	private int offset;
	private int limit;
	private int totalcnt;

	
}
