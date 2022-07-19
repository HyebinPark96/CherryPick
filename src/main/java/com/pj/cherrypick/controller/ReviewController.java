package com.pj.cherrypick.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReviewController {
	
	
	@GetMapping("/review/writeReview/{cno}")
	public String writeReview(@PathVariable int cno, Model model) {
		model.addAttribute("cno", cno);
		
		return "review/writeReview";
	}
}
