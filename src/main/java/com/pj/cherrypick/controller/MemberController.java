package com.pj.cherrypick.controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.service.MemberService;

@RestController
@RequestMapping("/member")
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
>>>>>>> a06ddc334869e09e83cb63a62576855d3668bfc0
public class MemberController {
	// http://localhost/auth/joinForm
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
<<<<<<< HEAD
	@Autowired
	private MemberService memberService;
	
=======
	
	@GetMapping("/auth/loginForm")
	// http://localhost/auth/loginForm
	public String loginForm() {
		System.out.println("loginForm() 호출");
		return "member/loginForm"; // /WEB-INF/views/templates/loginForm
	}
>>>>>>> a06ddc334869e09e83cb63a62576855d3668bfc0
}
