package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.cherrypick.config.auth.PrincipalDetail;
import com.pj.cherrypick.domain.BookmarkVO;
import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.mapper.CafeMapper;
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
		
		String username = "aaa";
		//String username = principalDetail.getUsername();
		
		List<CafeVO> cafes = cafeService.getCafeAll();				
		model.addAttribute("cafes", cafes);

		
		return "cafe/all";
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

	// 개별카페 상세정보
	@GetMapping("/cafe/info/{cno}")
	public String getCafe(@AuthenticationPrincipal PrincipalDetail principalDetail, @PathVariable int cno, Model model) throws Exception {
		
		String username = "aaa"; // 테스트용 나중엔 시큐리티 적용
		//시큐리티
		//String username = principalDetail.getUsername();
		
		CafeVO cafe = cafeService.getCafeInfo(cno); // cno로 해당하는 카페 info 출력
		List<CafeMenuVO> menu = cafeService.getCafeMenu(cno); // cno로 해당하는 카페 menu 출력 
		List<ReviewVO> review = cafeService.getReview(cno); // cno로 해당하는 카페 review 출력
		model.addAttribute("cafe", cafe);
		model.addAttribute("menu", menu);
		model.addAttribute("review", review);
		
		// 현재 로그인 유저가 이 카페 북마크 했는지 안 했는지 (1 = 했음, 0 = 안했음)
		bookmarkService.checkCafeBmk(username, cno);  
		int bmk = bookmarkService.checkCafeBmk(username, cno);
		// System.out.println(bmk);
		model.addAttribute("bmk", bmk);
	
		return "cafe/info";
	}
		
	// 카페 북마크 추가 (bmk) AJAX에서 요청한 정보를 받아서 처리후 보내는 메서드
	@RequestMapping("/cafe/bmk")
	public @ResponseBody int bmk(String username, int cno) throws Exception {
		
		int result = bookmarkService.addBmkc(username, cno);
		return result;
	}	


	
	

}
