package com.pj.cherrypick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pj.cherrypick.mapper.MemberMapper;


@Controller
public class MyBatisConnTestController {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@GetMapping("/listmap")
	public String listmap(Model model) {
		model.addAttribute("list", memberMapper.listmap());
		return "myBatisConnTest";
	}

}
