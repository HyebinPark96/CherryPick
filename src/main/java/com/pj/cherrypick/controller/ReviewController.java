package com.pj.cherrypick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.service.CafeService;
import com.pj.cherrypick.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	CafeService cafeService;
	
	@GetMapping("/review/writeReview/{cno}")
	public String writeReview(@PathVariable int cno, Model model) throws Exception {
		
		CafeVO cafe = new CafeVO();
		
		if(cafeService.getCafeInfo(cno)!=null) {
			cafe = cafeService.getCafeInfo(cno);
		}
		
		model.addAttribute("cafe", cafe);
		model.addAttribute("cno", cno);
		
		return "review/writeReview";
	}
	
	@GetMapping("/member/updateReview")
	public String updateReview(@RequestParam("rno") int rno, @RequestParam("cname") String cname, 
			@RequestParam("num") int num, Model model) {
		
		// System.out.println("rno : " + rno);
		
		ReviewVO review = new ReviewVO();
		
		if(reviewService.getOneReviewForUpdate(rno) != null) {
			review = reviewService.getOneReviewForUpdate(rno);
		};
		
		model.addAttribute("review", review);
		model.addAttribute("cname", cname);
		model.addAttribute("num", num);
		
		return "review/updateReview";
	}
}
