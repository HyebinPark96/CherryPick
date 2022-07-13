package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pj.cherrypick.domain.BizMemberVO;

@Controller
public class BizMemberController {
	
	// http://localhost/auth/findBIdForm
	@GetMapping("/auth/findBIdForm")
	public String findBUsernameForm() {
		return "bizMember/findusernameForm"; // /WEB-INF/views/templates/bizMember/findusernameForm
	}
	
	// http://localhost/auth/findBpwdForm
	@GetMapping("/auth/findBpwdForm")
	public String findBPasswordForm() {
		return "bizMember/findPasswordForm"; // /WEB-INF/views/templates/bizMember/findPasswordForm
	}
	
	
	
	
	
}
