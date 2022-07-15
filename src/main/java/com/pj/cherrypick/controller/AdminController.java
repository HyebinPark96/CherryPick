package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	// 페이징 테스트를 위한 매핑
	@GetMapping("/admin/testForPaging")
	public String testForPaging() {
		return "admin/testForPaging";
	}
	

}
