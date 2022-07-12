package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pj.cherrypick.domain.BizMemberVO;

@Controller
public class BizMemberController {
	@GetMapping("/bizMember/myPage")
	public String myPage(@SessionAttribute(name = "bizMember", required = false)BizMemberVO bizMember, Model model) {
		model.addAttribute("bizMember", bizMember);
		return "bizMember/myPage"; // model 들고 뷰로 이동
	}
}
