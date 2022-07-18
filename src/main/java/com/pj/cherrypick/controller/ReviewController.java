package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {
	
	@GetMapping("/review/writeReview")
	public String writeReview() {
		return "review/writeReview";
	}
}
