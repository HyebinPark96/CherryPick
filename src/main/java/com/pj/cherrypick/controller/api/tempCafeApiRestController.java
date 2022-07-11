package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.CafeService;

@RestController
public class tempCafeApiRestController {
	
	@Autowired
	private CafeService cafeService;
	
	@PostMapping("/auth/regCafeProc")
	public ResponseDto<Integer> save(@RequestBody CafeVO cafe) throws Exception{
		cafeService.createCafe(cafe);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
