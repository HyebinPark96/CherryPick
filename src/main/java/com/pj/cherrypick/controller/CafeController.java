package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.service.CafeService;


@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	// 카페목록
	@GetMapping("cafe/list")
	public String cafeList(Model model) {
		System.out.println("카페리스트 실행");
		List<CafeVO> cafes = cafeService.getCafePreviewList();
		model.addAttribute("cafes", cafes);
		return "cafe/list";
		}

	
	// 카페상세정보
	@GetMapping("/{cno}")
	public CafeVO getCafe(@PathVariable int cno) {
		System.out.println("카페정보 실행");
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
