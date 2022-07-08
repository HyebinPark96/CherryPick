package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
}
