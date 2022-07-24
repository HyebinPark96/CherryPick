package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.ReviewService;

@RestController
public class ReviewApiRestController {
	
	@Autowired
	ReviewService reviewService;
	
	@PostMapping("/review/writeReviewProc")
	public ResponseDto<Integer> writeReviewProc(@RequestBody ReviewVO reviewVO) {

		reviewService.writeReviewProc(reviewVO);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PutMapping("/review/updateReviewProc")
	public ResponseDto<Integer> updateReviewProc(@RequestBody ReviewVO reviewVO) {
		
		reviewService.updateReviewProc(reviewVO);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
