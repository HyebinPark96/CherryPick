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
	private String mid;
	private String liname;
	private int li_cafe1;
	private int li_cafe2;
	private int li_cafe3;
	private int li_cafe4;
	private int li_cafe5;
	

}
