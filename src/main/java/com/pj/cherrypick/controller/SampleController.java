package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {


	@GetMapping(value = "/demo1")
	public void demo1() {
		System.out.println("demo1 호출");
	}
	
	@GetMapping(value = "/demo2")
	public void demo2() {
		System.out.println("demo2 호출");
	}
	
	@GetMapping(value = "/demo3")
	public void demo3() {
		System.out.println("demo3 호출");
	}
	
	@GetMapping(value = "/demologin")
	public void demologin() {
	}
	
	@GetMapping(value = "/demojoin")
	public void demojoin() {
	}
	
	@GetMapping(value = "/demobmk")
	public void demobmk() {
	}
	
	@GetMapping(value = "/demoreview")
	public void demoreview() {
	}
	
	@GetMapping(value = "/demoregcafe")
	public void demoregcafe() {
	}
	
	
	@GetMapping(value = "/demoadmin")
	public void demoadmin() {
	}
	
	@GetMapping(value = "/test")
	public String test(Model model) {
		
		return "";
	}
	
} 






































