package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pj.cherrypick.service.CafeService;
import com.pj.cherrypick.service.ReviewService;

@Controller
public class ReviewApiController {
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	CafeService cafeService;
	


	
}
