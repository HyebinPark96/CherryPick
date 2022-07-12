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
	private String username;
	private String password;
	private String bname;
	private int bstat;
	private String bPhone;
	private String bEmail;
}
