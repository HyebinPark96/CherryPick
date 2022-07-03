package com.pj.cherrypick.test;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SampleController {
	
	@GetMapping(value = "/demo1")
	public void demo1() {}
	
	@GetMapping(value = "/demo2")
	public void demo2() {}
	
	@GetMapping(value = "/demo3")
	public void demo3() {}

} 






































