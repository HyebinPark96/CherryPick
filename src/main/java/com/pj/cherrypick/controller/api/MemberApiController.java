package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.cherrypick.service.MemberService;

@Controller
public class MemberApiController {
	
	@Autowired
	private MemberService memberService; // 스프링이 컴포넌트 스캔을 통해 MemberService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌 (=IOC 해줌)
	
	@PostMapping("/auth/findUsernameProc")
	public String findUsername(@RequestParam("name") String name, @RequestParam("email") String email, Model model) throws Exception {
		System.out.println("name : " + name);
		System.out.println("email : " + email);
		model.addAttribute("username", memberService.findUsername(name, email));
		return "member/findUsernameResult";
	}
}
