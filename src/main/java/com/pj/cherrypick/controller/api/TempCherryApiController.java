package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.TempCherryService;

@RestController
public class TempCherryApiController {

	@Autowired
	private TempCherryService tCherryService;


	@PostMapping("/member/regListProc")
	public ResponseDto<Integer> addCherry(@RequestBody ListVO list) throws Exception{
	
		System.out.println("uplist On");
		int result = tCherryService.addCherry(list);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);		
	}

}
