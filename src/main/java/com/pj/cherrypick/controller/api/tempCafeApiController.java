package com.pj.cherrypick.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.response.TempResponseDto;
import com.pj.cherrypick.service.StorageService;
import com.pj.cherrypick.service.TempCafeService;
import com.pj.cherrypick.storage.StorageFileNotFoundException;

@RestController
public class tempCafeApiController {

	@Autowired
	private TempCafeService cafeService;
	
	private final StorageService storageService;

	@Autowired
	public tempCafeApiController(StorageService storageService) {
		this.storageService = storageService;
	}
	
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
	
	@PostMapping("/cafe/regCafeProc")
	public TempResponseDto<Integer> save(@RequestBody CafeVO cafe) {
		//리턴 값 하나가 추가된 TempResponseDto를 사용한다.
		System.out.println("tempCaf On");
		int result = cafeService.createCafe(cafe);
		int cno = cafeService.getCafeNo();
		return new TempResponseDto<Integer>(HttpStatus.OK.value(), result, cno);
		// 자바 오브젝트를 Json으로 변환해서 리턴(Jackson)
	}
	
	@PostMapping("/cafe/updateCafeProc")
	public ResponseDto<Integer> updateCafe(@RequestBody CafeVO cafe) throws Exception{
		System.out.println("upCaf On");
		int result = cafeService.updateCafe(cafe);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}
	
	
	
	@PostMapping("/cafe/regMenuProc")
	public ResponseDto<Integer> saveMenu(@RequestBody List<CafeMenuVO> menu){
		int result = 0;
		for (int i = 0; i < menu.size(); i++) {
			System.out.println("cno = " + menu.get(i).getCno());
			int m = cafeService.createMenu(menu.get(i));

			if(m==1 && result != -1) {
				result = 1;
				System.out.println(result);
			}else{
				result = -1;
			};
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);		
	}

	@PostMapping("/cafe/updateMenuProc")
	public ResponseDto<Integer> updateMenu(@RequestBody List<CafeMenuVO> menu) throws Exception{
		int result = 0;
		for (int i = 0; i < menu.size(); i++) {
			int m = cafeService.updateMenu(menu.get(i));

			if(m==1 && result != -1) {
				result = 1;
				System.out.println(result);
			}else{
				result = -1;
			};
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}
	
	

}
