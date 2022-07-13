package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Builder
public class BizMemberVO {
	private String bid;
	private String bpwd;
	private String bname;
	private int bstat;
	private String bphone;
	private String bemail;
}
