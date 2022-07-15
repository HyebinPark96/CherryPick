package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pj.cherrypick.domain.BizMemberVO;

@Controller
public class SampleController {
	
	@GetMapping({"","/"})
	public String demomain(@SessionAttribute(name = "bizMember", required = false)BizMemberVO bizMember, Model model) {
		model.addAttribute("bizMember", bizMember);
		return "demomain";
	}
	
	@GetMapping(value = "/demo1")
	public void demo1() {
		
	}
	
	@GetMapping(value = "/demo2")
	public void demo2() {
		
	}
	
	@GetMapping(value = "/demo3")
	public void demo3() {
		
	}
	
	
	@GetMapping(value = "/demoreview")
	public void demoreview() {
	}
	
	@GetMapping(value = "/regcafe")
	public String demoregcafe() {
		return "/bizmember/regcafe";
	}
	
	
	@GetMapping(value = "/demoadmin")
	public void demoadmin() {
	}
	
	@GetMapping(value = "/test")
	public String test(Model model) {
		
		return "test";
	}
	
} 






































