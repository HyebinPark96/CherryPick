package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pj.cherrypick.domain.BizMemberVO;

@Controller
public class BizMemberController {
	
	// http://localhost/auth/findBUsernameForm
	@GetMapping("/auth/findBUsernameForm")
	public String findBUsernameForm() {
		return "bizMember/findusernameForm"; // /WEB-INF/views/templates/bizMember/findusernameForm
	}
	
	// http://localhost/auth/findBPasswordForm
	@GetMapping("/auth/findBPasswordForm")
	public String findBPasswordForm() {
		return "bizMember/findPasswordForm"; // /WEB-INF/views/templates/bizMember/findPasswordForm
	}
	
	
	
	
	
}
