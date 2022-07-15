package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.domain.Page;
import com.pj.cherrypick.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	/*1. 일반회원*/
	// 게시물 목록 + 페이징 추가
	@RequestMapping(value = "/admin/adminMain", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception{ // num : 페이지 번호
		Page page = new Page();
		
		page.setNum(num);
		System.out.println(num);
		page.setCount(adminService.count());  

		List<MemberVO> list = null; 
		list = adminService.listPage(page.getDisplayPost(), page.getPostNum());

		model.addAttribute("list", list); 
		model.addAttribute("page", page);
		model.addAttribute("select", num);
	}
	
	
	
	/*2. 사업자회원*/
	
}
