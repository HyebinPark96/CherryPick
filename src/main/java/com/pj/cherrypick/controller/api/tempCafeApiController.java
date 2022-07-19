package com.pj.cherrypick.controller.api;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.TempCafeService;

@RestController
public class tempCafeApiController {
	
	@Autowired
	private TempCafeService cafeService;
	
	@PostMapping("/cafe/regCafeProc")
	public ResponseDto<Integer> save(@RequestBody CafeVO cafe) {
		System.out.println("tempCaf On");
		int result = cafeService.createCafe(cafe);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
		//자바 오브젝트를 Json으로 변환해서 리턴(Jackson)
	}
	
	
}
