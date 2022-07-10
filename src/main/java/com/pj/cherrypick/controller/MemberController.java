package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	// http://localhost/auth/joinForm
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "member/joinForm"; // // /WEB-INF/views/templates/member/joinForm
	}
	
	@GetMapping("/auth/loginForm")
	// http://localhost/auth/loginForm
	public String loginForm() {
		return "member/loginForm"; // /WEB-INF/views/templates/member/loginForm
	}
	
	@GetMapping("/auth/findUsernameForm")
	// http://localhost/auth/findIdForm
	public String findUsernameForm() {
		return "member/findUsernameForm"; // /WEB-INF/views/templates/member/findIdForm
	}
	
	@GetMapping("/auth/findPasswordForm")
	// http://localhost/auth/findPwdForm
	public String findPasswordForm() {
		return "member/findPasswordForm"; // /WEB-INF/views/templates/member/findPwdForm
	}


}
