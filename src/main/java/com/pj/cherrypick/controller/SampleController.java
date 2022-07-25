package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.HomeVO;
import com.pj.cherrypick.service.HomeService;

@Controller
public class SampleController {
	
	
	@Autowired
	private HomeService homeservice;
	
	@GetMapping({"","/"})
	public String demomain(@SessionAttribute(name = "bizMember", required = false)BizMemberVO bizMember, Model model) {
		model.addAttribute("bizMember", bizMember);
		List<HomeVO> today = homeservice.getTodayList();
		model.addAttribute("today", today);
		System.out.println("[model]:"+model);
		System.out.println("[today]:"+today);
		return "index";
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
	
	@GetMapping(value = "/teststar")
	public String teststar(Model model) {
		
		return "testStar";
	}
	
	
	  @GetMapping(value = "/uploadForm") public String uploadForm(Model model) {
	  
	  return "uploadForm"; }
	
	
} 






































