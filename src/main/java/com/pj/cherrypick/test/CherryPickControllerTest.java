package com.pj.cherrypick.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // IoC : 스프링 컨테이너가 관리
public class CherryPickControllerTest {

	// http://localhost:8080/test/hello
	@GetMapping("test/hello")
	public String hello() {
		return "<h1>Test2</h1>";
	}
}
