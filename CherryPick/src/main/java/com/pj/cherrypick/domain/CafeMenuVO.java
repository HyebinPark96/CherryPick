package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Builder
public class CafeMenuVO {
	
	private int meno;
	private int cno;
	private String m_name;
	private String m_img;
	private String m_detail;
	private String m_size;
	private int m_price;
	private String m_tag;
	
}
