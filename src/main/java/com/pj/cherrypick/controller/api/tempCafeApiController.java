package com.pj.cherrypick.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.response.ResponseDto;

@RestController
public class tempCafeApiController {
	
	@PostMapping("/cafe/regCafeProc")
	public ResponseDto<Integer> save(@RequestBody CafeVO cafe) {
		System.out.println("tempCaf On");
		return new ResponseDto<Integer>(200, 1);
	}
}
