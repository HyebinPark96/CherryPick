package com.pj.cherrypick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	
	@GetMapping("/review/writeReview/{cno}")
	public String writeReview(@PathVariable int cno) {
		
		// System.out.println(cno);
		ReviewVO reviewVO = new ReviewVO();
		reviewService.writeReviewProc(reviewVO, cno);
		
		return "review/writeReview";
	}
}
