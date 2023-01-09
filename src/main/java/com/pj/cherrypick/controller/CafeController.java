package com.pj.cherrypick.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.cherrypick.config.auth.PrincipalDetail;
import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.FilterVO;
import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.domain.Page;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.service.BookmarkService;
import com.pj.cherrypick.service.CafeService;

@Controller
public class CafeController {

	@Autowired
	private CafeService cafeService;
	@Autowired
	private BookmarkService bookmarkService;
	
	
	// CafeList
	@RequestMapping("cafe/all")
	public String getCafeList(@AuthenticationPrincipal PrincipalDetail principalDetail, 
			@RequestParam(required=false, defaultValue="0") Integer sort, 
			@RequestParam(required=false, defaultValue="0") Integer fpark, 
			@RequestParam(required=false, defaultValue="0") Integer fgroup,
			@RequestParam(required=false, defaultValue="0") Integer fpet,
			@RequestParam(required=false, defaultValue="0") Integer fkids, Model model) throws Exception {
		

		//System.out.println("controller:getCafeList---------------------------------------");
		//System.out.println("[sort]: "+sort+"  [fpark]: "+fpark+" [fgroup]:"+fgroup+" [fpet]:"+fpet+" [fkids]:"+fkids);
		
		String username = "aaa";
		//String username = principalDetail.getUsername();
		model.addAttribute("username", username);
		
		List<CafeVO> cafes = new ArrayList<>(); 
		FilterVO filter = new FilterVO();
		
		filter.setSort(sort);
		filter.setFgroup(fgroup);
		filter.setFkids(fkids);
		filter.setFpark(fpark);
		filter.setFpet(fpet);
		
		model.addAttribute("filter", filter);
						
		if(sort==0) { //최신순
			cafes = cafeService.getCafeAll2(filter);	
			model.addAttribute("cafes", cafes);	
		}else if(sort==1) { // 즐겨찾기순
			cafes = cafeService.getCafeAllByBmk(filter);	
			model.addAttribute("cafes", cafes);	
		}else if(sort==2) { // 별점순
			cafes = cafeService.getCafeAllByScore(filter);	
			model.addAttribute("cafes", cafes);
		}else if(sort==3) { // 리뷰많은순
			cafes = cafeService.getCafeAllByReview(filter);	
			model.addAttribute("cafes", cafes);	
		}
				
		//System.out.println("[username]:"+username);
		//System.out.println("[cafes]:"+cafes);
		//System.out.println("[model]:"+model);	
		
		return "cafe/all";
	}	
	
	

	// response for ajax request from cafe.js 
	@RequestMapping("cafe/select")
	@ResponseBody
	public List<CafeVO> selectCafe(@RequestParam int number) throws Exception {
		
		//System.out.println("ResponseBody: selectCafe--------------------------------------------");
		//System.out.println(number);
		List<CafeVO> cafes = cafeService.getCafeAll();
				
		return cafes;
	}	

	
	// 카페리스트 (전체카페X lino로 리스트 불러오기)
	@GetMapping("cafe/list/{lino}")
	public String getEachList(@AuthenticationPrincipal PrincipalDetail principalDetail,
			@PathVariable int lino, Model model) throws Exception {
	
		//String username = "aaa"; // 테스트용 나중엔 시큐리티 적용
		//시큐리티
		//String username = principalDetail.getUsername();
		//model.addAttribute("username", username);

		String username = new String();

		// username을 시큐리티로 가져옵니다. 없으면 그냥 guest로 셋팅됨
		try {
			username = principalDetail.getUsername();
		}catch(Exception e) {
			username = "guest";
		}finally {
			model.addAttribute("username", username);
		}

		ListVO list = cafeService.getEachList(lino);
		List<CafeVO> cafes = cafeService.getCafeList(lino);
		model.addAttribute("list", list);
		model.addAttribute("cafes", cafes);
		
		// 현재 로그인 유저가 이 리스트를 북마크 했는지 안 했는지 (1 = 했음, 0 = 안했음)
		bookmarkService.checkListBmk(username, lino);
		int bmk = bookmarkService.checkListBmk(username, lino);
		System.out.println(bmk);
		model.addAttribute("bmk", bmk);
		
		
		return "cafe/list";
	}
	
	// 카페 북마크 추가 (bmk) AJAX에서 요청한 정보를 받아서 처리후 보내는 메서드
	@RequestMapping("/cafe/bmkli")
	public @ResponseBody int bmkli(String username, int lino) throws Exception {
		
		int result = bookmarkService.addBmkli(username, lino);
		return result;
	}	


	// 개별카페 상세정보
	@GetMapping("/cafe/info/{cno}")
	public String getCafe(@AuthenticationPrincipal PrincipalDetail principalDetail, 
			@PathVariable int cno, @RequestParam(defaultValue="1") int num, Model model) throws Exception {
		
		//int num = 페이징
		Page page = new Page();
		
		// String username = "aaa"; // 테스트용 나중엔 시큐리티 적용

		//시큐리티
		String username = new String();
		//String username = principalDetail.getUsername();

		// username을 시큐리티로 가져옵니다. 없으면 그냥 guest로 셋팅됨
		try {
			username = principalDetail.getUsername();
		}catch(Exception e) {
			username = "guest";
		}finally {
			model.addAttribute("username", username);
		}	// username을 시큐리티로 가져옵니다. 없으면 그냥 guest로 셋팅됨
		try {
			username = principalDetail.getUsername();
		}catch(Exception e) {
			username = "guest";
		}finally {
			model.addAttribute("username", username);
		}
		//model.addAttribute("username", username);
		
		CafeVO cafe = cafeService.getCafeInfo(cno); // cno로 해당하는 카페 info 출력
		List<CafeMenuVO> menu = cafeService.getCafeMenu(cno); // cno로 해당하는 카페 menu 출력 
		List<ReviewVO> review = cafeService.getReview(cno, page.getDisplayPost(), page.getPostNum()); // cno로 해당하는 카페 review 출력
		
		
		// 페이징
		
		page.setNum(num);
		page.setCount(cafeService.cntReview(cno)); // 총게시글수 = 리뷰목록 길이

		
		model.addAttribute("cafe", cafe);
		model.addAttribute("menu", menu);
		model.addAttribute("review", review);
		model.addAttribute("page", page);
		model.addAttribute("select", num); // 현재 페이지 (현재 페이지가 아닌 페이지와 구분하기 위해 값 전달)


		// 현재 로그인 유저가 이 카페 북마크 했는지 안 했는지 (1 = 했음, 0 = 안했음)
		bookmarkService.checkCafeBmk(username, cno);  
		int bmk = bookmarkService.checkCafeBmk(username, cno);
		model.addAttribute("bmk", bmk);

		System.out.println("username:"+username);
		System.out.println("bmk:"+bmk);
	
		return "cafe/info";
	}
		
	// 카페 북마크 추가 (bmk) AJAX에서 요청한 정보를 받아서 처리후 보내는 메서드
	@RequestMapping("/cafe/bmk")
	public @ResponseBody int bmk(String username, int cno) throws Exception {
		
		int result = bookmarkService.addBmkc(username, cno);
		return result;
	}	

}
