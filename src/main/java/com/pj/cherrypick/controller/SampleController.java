package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pj.cherrypick.domain.BizMemberVO;

@Controller
public class SampleController {
	
	@GetMapping({"","/"})
	public String demomain(@SessionAttribute(name = "bizMember", required = false)BizMemberVO bizMember, Model model) {
		model.addAttribute("bizMember", bizMember);
		return "demomain";
	}
	
	@PostMapping("/bizMember/storeRegister")
	public String storeManagement(@SessionAttribute(name = "bizMember", required = false) BizMemberVO bizMember, Model model) {
		model.addAttribute("bizMember", bizMember);
		return "bizMember/storeRegister"; // model 들고 뷰로 이동
	}
	
	
	@GetMapping(value = "/demo2")
	public String demo2(Model model) {
		
		return "demo2";
	}
	
	@GetMapping(value = "/test")
	public String test(Model model) {
		
		return "withdrawalResult";
	}
	
	
	@GetMapping(value = "/test2")
	public String test2(Model model) {
		
		return "test2";
	}
	
	@GetMapping(value = "/test3")
	public String test3(Model model) {
		
		return "test3";
	}
	
	@GetMapping(value = "/test4")
	public String test4(Model model) {
		
		return "test4";
	}
	
	@GetMapping(value = "/uploadForm")
	public String uploadForm(Model model) {
		
		return "uploadForm";
	}
	
	
	
} 






































