package com.pj.cherrypick.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.service.CafeService;

@RestController
public class RestCafeController {

//	private static final Logger logger = LoggerFactory.getLogger(CafeController.class);
//	
//	@Autowired
//	private CafeService cafeService;
//	
//	@GetMapping("cafe/all")
//	public String getCafeAll(@PathVariable(required=false) String sort) throws Exception {
//		
//		if (sort=="0" || sort==null || sort.equals(null)) {
//			
//			sort="0"; 
//			List<CafeVO> cafes = cafeService.getCafeAll();
//			
//		} else {
//			List<CafeVO> cafes = cafeService.getCafeAllByScore();
//		}
//		
//		return "cafe/all";
//		
//	}
	
	
}
