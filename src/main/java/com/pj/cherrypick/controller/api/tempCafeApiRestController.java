package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.TempCafeService;

@RestController
public class tempCafeApiRestController {
	
//	@Autowired
//	private TempCafeService cafeService;
//	
//	@PostMapping("/cafe/regCafeProc")
//	public ResponseDto<Integer> save(@RequestBody CafeVO cafe) throws Exception{
//		System.out.println("save함수 호출됨 : " + cafe.getCname());
//		cafeService.createCafe(cafe);
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//	}
//	
//	@PostMapping("/auth/regCafeProc")
//	public String test(CafeVO cafe) throws Exception{
//		System.out.println(cafe.getCname());
//		return cafe.getCname();
//	}
}
