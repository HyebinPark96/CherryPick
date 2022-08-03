package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.cherrypick.service.ReviewService;

@Controller
public class ReviewApiController {
	
	@Autowired
	ReviewService reviewService;
	
	@DeleteMapping("/review/deleteReview")
	public String deleteReview(@RequestParam("rno") int rno, @RequestParam("num") int num) throws Exception {
		reviewService.deleteReviewProc(rno);
		return "redirect:/member/myReview?num=" + num;
	}
	
	@DeleteMapping("/review/deleteReviewFromCafe")
	public String deleteReviewFromCafe(@RequestParam("rno") int rno, @RequestParam("num") int num, @RequestParam("cno") int cno) throws Exception {
		reviewService.deleteReviewProc(rno);
		return "redirect:/cafe/info/" + cno + "?num=" + num;
	}
	
}
