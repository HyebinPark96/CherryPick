package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.mapper.CafeMapper;
import com.pj.cherrypick.service.CafeService;

@RestController
@RequestMapping("/cafe")
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	// 카페목록
	@GetMapping("/list")
	public List<CafeVO> getCafeList() {
		return cafeService.getCafeList();
		}

	
	
	// 카페상세정보
	@GetMapping("/{cno}")
	public CafeVO getCafe(@PathVariable int cno) {
		return cafeService.getCafe(cno);
	}
	
	// 카페 등록
	@GetMapping("/create")
	public int createCafe(CafeVO cafe) {
		return cafeService.createCafe(cafe);
	}
	
	// 카페 수정
	@GetMapping("/update")
	public int updateCafe(CafeVO cafe) {
		return cafeService.updateCafe(cafe);
	}
	
	// 카페 삭제
	@GetMapping("/delete/{cno}")
	public int deleteCafe(@PathVariable int cno) {
		return cafeService.deleteCafe(cno);
	}
	

	
}
