package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.service.HomeService;

@Controller
public class HomeController {

	
	@Autowired
	private HomeService homeservice;
	
	// 홈화면
	@GetMapping("/home")
	public String getCafeAll(Model model) {
		List<ListVO> today = homeservice.getTodayList();
		model.addAttribute("today", today);
		return "home";
		}
	
}
