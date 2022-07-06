package com.pj.cherrypick.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data 
public class MemberVO {

	private String mid;
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private int role; // USER, ADMIN 둘 중 하나만 사용 가능
	
}