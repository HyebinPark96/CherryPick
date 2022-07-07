package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data 
@Builder
public class MemberVO {

	private String username;
	private String password;
	private String name;
	private String phone;
	private String email;
	private int role;
	
}