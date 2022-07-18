package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pj.cherrypick.config.auth.PrincipalDetail;
import com.pj.cherrypick.domain.BookmarkVO;
import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.service.BookmarkService;
import com.pj.cherrypick.service.CafeService;

@Controller
public class CafeController {

	@Autowired
	private CafeService cafeService;
	@Autowired
	private BookmarkService bookmarkService;

	// 전체 카페목록


	@GetMapping("/cafe/all")
	public String getCafeAll(Model model) {
		
		String username = "aaa"; //테스트용
		// 카페리스트
		List<CafeVO> cafes = cafeService.getCafeAll();
		model.addAttribute("cafes", cafes);
		// 사용자가 즐겨찾기 했는지 리스트 ???
		
		return "cafe/all";
	}

	@GetMapping("/cafe/test")
	public String gettest(Model model) throws Exception {
		
		String username = "aaa";
		List<BookmarkVO> bmk = bookmarkService.checkBmkc(username, 1);
		model.addAttribute("bmk", bmk);
		System.out.println("model:"+model);

		return "cafe/test";
	}
	
	
	
	
	// 카페리스트 (전체카페X lino로 리스트 불러오기)
	@GetMapping("cafe/list/{lino}")
	public String getEachList(@PathVariable int lino, Model model) {
		ListVO list = cafeService.getEachList(lino);
		List<CafeVO> cafes = cafeService.getCafeList(lino);
		model.addAttribute("list", list);
		model.addAttribute("cafes", cafes);
		return "cafe/list";
	}

	// 카페상세정보
	@GetMapping("cafe/{cno}")
	public String getCafe(@AuthenticationPrincipal PrincipalDetail principalDetail, @PathVariable int cno, Model model) throws Exception {
		
		String username = "aaa"; // 테스트 나중엔 시큐리티 적용
		CafeVO cafe = cafeService.getCafeInfo(cno);
		List<CafeMenuVO> menu = cafeService.getCafeMenu(cno);
		List<ReviewVO> review = cafeService.getReview(cno);
		BookmarkVO bmk = bookmarkService.checkCafeBmk(username, cno);
		model.addAttribute("cafe", cafe);
		model.addAttribute("menu", menu);
		model.addAttribute("review", review);
		model.addAttribute("bmk", bmk);


		return "cafe/info";
		
	}
		

	


	

}
