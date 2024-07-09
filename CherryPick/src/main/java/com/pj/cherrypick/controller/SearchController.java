package com.pj.cherrypick.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.cherrypick.config.auth.PrincipalDetail;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.FilterVO;
import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.service.CafeService;
import com.pj.cherrypick.service.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	CafeService cafeService;
	
	@Autowired
	SearchService searchService;


	// CafeList
	@GetMapping("/search")
	public String getCafeList(@AuthenticationPrincipal PrincipalDetail principalDetail, HttpServletRequest req,
			@RequestParam(value = "keyword") String keyword, 
			@RequestParam(required=false, defaultValue="0") Integer sort, 
			@RequestParam(required=false, defaultValue="0") Integer fpark, 
			@RequestParam(required=false, defaultValue="0") Integer fgroup,
			@RequestParam(required=false, defaultValue="0") Integer fpet,
			@RequestParam(required=false, defaultValue="0") Integer fkids, Model model) throws Exception {
		

		//System.out.println("controller:getCafeList---------------------------------------");
		//System.out.println("[sort]: "+sort+"  [fpark]: "+fpark+" [fgroup]:"+fgroup+" [fpet]:"+fpet+" [fkids]:"+fkids);
		
		
		List<CafeVO> cafes = new ArrayList<>(); 
		List<CafeVO> taggedCafes = new ArrayList<>();
		List<ListVO> lists = new ArrayList<>();
		
		FilterVO filter = new FilterVO();
		
		filter.setSort(sort);
		filter.setFgroup(fgroup);
		filter.setFkids(fkids);
		filter.setFpark(fpark);
		filter.setFpet(fpet);
		
		cafes = searchService.getCafeByName(keyword, filter);
		lists = searchService.getListByName(keyword, filter);
		taggedCafes = searchService.getCafeByTag(keyword, filter);
		
		model.addAttribute("cafes", cafes);			
		model.addAttribute("taggedCafes", taggedCafes);
		model.addAttribute("lists", lists);			
		//System.out.println("[cafes]:"+cafes);
		//System.out.println("[model]:"+model);	
		
		model.addAttribute("filter", filter);
		
		model.addAttribute("keyword", keyword);
		
		System.out.println(taggedCafes);
		System.out.println(lists);
		
		
		
		return "search/search";
	}	
	
	
	/*
	

	// response for ajax request from cafe.js 
	@RequestMapping("cafe/select")
	@ResponseBody
	public List<CafeVO> selectCafe(@RequestParam int number) throws Exception {
		
		//System.out.println("ResponseBody: selectCafe--------------------------------------------");
		//System.out.println(number);
		List<CafeVO> cafes = cafeService.getCafeAll();
				
		return cafes;
	}	
	
	*/

	/*
	
	// 카페리스트 (전체카페X lino로 리스트 불러오기)
	@GetMapping("cafe/list/{lino}")
	public String getEachList(@AuthenticationPrincipal PrincipalDetail principalDetail,
			@PathVariable int lino, Model model) throws Exception {
	
		String username = "aaa"; // 테스트용 나중엔 시큐리티 적용
		model.addAttribute("username", username);
		//시큐리티
		//String username = principalDetail.getUsername();
		
		ListVO list = cafeService.getEachList(lino);
		List<CafeVO> cafes = cafeService.getCafeList(lino);
		model.addAttribute("list", list);
		model.addAttribute("cafes", cafes);
		
		// 현재 로그인 유저가 이 리스트를 북마크 했는지 안 했는지 (1 = 했음, 0 = 안했음)
		bookmarkService.checkListBmk(username, lino);
		int bmk = bookmarkService.checkListBmk(username, lino);
		//System.out.println(bmk);
		model.addAttribute("bmk", bmk);
		
		
		return "cafe/list";
	}
	
	*/
	
}
