package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	// http://localhost/auth/joinForm
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	
	@GetMapping("/auth/loginForm")
	// http://localhost/auth/loginForm
	public String loginForm() {
		System.out.println("loginForm() 호출");
		return "member/loginForm"; // /WEB-INF/views/templates/loginForm
	}
}
