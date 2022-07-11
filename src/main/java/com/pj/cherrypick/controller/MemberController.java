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
	
	@GetMapping("/auth/myPage")
	// http://localhost/auth/findPwdForm
	public String myPage() {
		return "member/myPage";
	}
	
	@GetMapping("/auth/adminMain")
	public String adminMain() {
		// 관리자가 로그인하면 헤더에 있는 adminMain 카테고리로 접근 가능하지만,
		// 회원이 url로 접근할 수 있으므로, 이를 방지하기 위해 멤버인지 관리자인지 체크하는 서비스 필요
		return "admin/adminMain"; // /WEB-INF/views/templates/member/adminMain
	}
	
	@GetMapping("/auth/memberEditForm")
	// http://localhost/auth/findPwdForm
	public String memberEditForm() {
		return "member/memberEditForm";
	}
	


}
