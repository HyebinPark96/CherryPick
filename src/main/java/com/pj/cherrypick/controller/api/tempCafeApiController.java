package com.pj.cherrypick.controller.api;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.StorageService;
import com.pj.cherrypick.service.TempCafeService;
import com.pj.cherrypick.storage.StorageFileNotFoundException;

@RestController
public class tempCafeApiController {

	@Autowired
	private TempCafeService cafeService;

	/**/
	private final StorageService storageService;

	@Autowired
	public tempCafeApiController(StorageService storageService) {
		this.storageService = storageService;
	}
	/**/

//
	@PostMapping("/cafe/regCafeProc")
	public ResponseDto<Integer> save(@RequestBody CafeVO cafe) {
		System.out.println("tempCaf On");
		int result = cafeService.createCafe(cafe);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
		// 자바 오브젝트를 Json으로 변환해서 리턴(Jackson)
	}

	// ==================================
//("/test")
	@RequestMapping("/cafe/uploadProc")
	public String upload(MultipartHttpServletRequest request) {
		System.out.println("upload on");
		List<MultipartFile> files = request.getFiles("files");

		for (MultipartFile file : files) {
			System.out.println(file.getOriginalFilename() + ":" + file.getSize());
			storageService.store(file);
		}

		return "uploaded";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

	// ==================================

}
