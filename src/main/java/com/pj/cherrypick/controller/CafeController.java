package com.pj.cherrypick.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pj.cherrypick.config.auth.PrincipalDetail;
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
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "aaa"); //값 추가
		map.put("cno", 2);
	//	String username = "aaa";
	//	int cno = 3;
		List<CafeVO> cafes = cafeService.getCafeAll();
		Boolean bmkc = bookmarkService.checkBmkc(map);
		model.addAttribute("cafes", cafes);
		model.addAttribute("bmkc", bmkc);
		System.out.println("map:"+map);
		System.out.println("bmkc:"+ bookmarkService.checkBmkc(map));
		System.out.println("model:"+model);

		return "/cafe/all";
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
	public String getCafe(@PathVariable int cno, Model model) {
		CafeVO cafe = cafeService.getCafeInfo(cno);
		List<CafeMenuVO> menu = cafeService.getCafeMenu(cno);
		List<ReviewVO> review = cafeService.getReview(cno);
		model.addAttribute("cafe", cafe);
		model.addAttribute("menu", menu);
		model.addAttribute("review", review);
		return "cafe/info";
	}

	@GetMapping("/member/myPage")
	public String getMyCafeBmk(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
		String username = principalDetail.getUsername();
		List<CafeVO> cafes = cafeService.getMyCafeBmk(username);
		List<ListVO> list = cafeService.getMyListBmk(username);
		model.addAttribute("cafes", cafes);
		model.addAttribute("list", list);
		return "/member/myPage";
	}
	
//	@GetMapping("/member/myPage")
	// http://localhost/member/myPage
//	public String myPage() {
//		return "member/myPage"; // /WEB-INF/views/templates/member/myPage
//	}
	

}
