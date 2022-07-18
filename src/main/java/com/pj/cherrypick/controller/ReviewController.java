package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ReviewController {
	
	public String writeReview() {
		return "member/writeReview";
	}
}
