package com.pj.cherrypick.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.cherrypick.config.auth.PrincipalDetail;
import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.FilterVO;
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
	@RequestMapping("cafe2")
	public FilterVO getCafeAllInit(@AuthenticationPrincipal PrincipalDetail principalDetail, 
			@RequestBody(required=false) FilterVO vo, Model model) throws Exception {
		
		FilterVO filter = new FilterVO();
		
		if (vo!=null) {
			filter.setFgroup(vo.getFgroup());
			filter.setFkids(vo.getFkids());
			filter.setFpark(vo.getFpark());
			filter.setFpet(vo.getFpark());
			filter.setSort(vo.getSort());
		}else {
			filter.setSort(0);
			filter.setFgroup(0);
			filter.setFkids(0);
			filter.setFpet(0);
			filter.setFpark(0);
		} 		
		
		System.out.println("---------------------------------------------");
		System.out.println("[filter]:"+filter);
		
		String username = "aaa";
		model.addAttribute("username", username);
		model.addAttribute("filter", filter);
		//String username = principalDetail.getUsername();
		
		Integer sort = filter.getSort();
		
		List<CafeVO> cafes = new ArrayList<>(); 
				
		if(sort==0 || sort ==null) { //최신순
	
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
				
		System.out.println("[username]:"+username);
		System.out.println("[cafes]:"+cafes);
		System.out.println("[model2]:"+model);
		
		return filter;
	}	
	
	

	// 전체 카페목록 
	@RequestMapping("cafe")
	public String getCafeAll(@AuthenticationPrincipal PrincipalDetail principalDetail, 
			@RequestBody(required=false) FilterVO vo, Model model) throws Exception {
		
		FilterVO filter = new FilterVO();
		
		if (vo!=null) {
			filter.setFgroup(vo.getFgroup());
			filter.setFkids(vo.getFkids());
			filter.setFpark(vo.getFpark());
			filter.setFpet(vo.getFpark());
			filter.setSort(vo.getSort());
		}else {
			filter.setSort(0);
			filter.setFgroup(0);
			filter.setFkids(0);
			filter.setFpet(0);
			filter.setFpark(0);
		} 		
		
		System.out.println("---------------------------------------------");
		System.out.println("[filter]:"+filter);
		
		String username = "aaa";
		model.addAttribute("username", username);
		model.addAttribute("filter", filter);
		//String username = principalDetail.getUsername();
		
		Integer sort = filter.getSort();
		
		List<CafeVO> cafes = new ArrayList<>(); 
				
		if(sort==0 || sort ==null) { //최신순
	
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
			
/*		List<BookmarkVO> list = new ArrayList<>();
		BookmarkVO vo = new BookmarkVO();
		BookmarkVO bmk = new BookmarkVO();
		
		for (int i = 0; i < cafes.size(); i++) {
			vo.setCno(cafes.get(i).getCno());
		//	System.out.println("cno:"+cafes.get(i).getCno());
			vo.setUsername(username);
		//	System.out.println("username:"+username);
		//	System.out.println("vo:"+vo);
			bmk = bookmarkService.checkCafeBmkAll(vo);
		//	System.out.println("bmk:"+bmk);
			list.add(i, bmk);
			// list에 있는 chk값 cafes로 넘기기
			cafes.get(i).setChk(list.get(i).getChk());
		}
	
		//System.out.println(cafes);
		//System.out.println(list);
*/	
		System.out.println("[username]:"+username);
		System.out.println("[cafes]:"+cafes);
		System.out.println("[model]:"+model);
		
		return "cafe/all";
	}	

	
	// 카페리스트 (전체카페X lino로 리스트 불러오기)
	@GetMapping("cafe/list/{lino}")
	public String getEachList(@AuthenticationPrincipal PrincipalDetail principalDetail, @PathVariable int lino, Model model) throws Exception {
	
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
	public String getCafe(@AuthenticationPrincipal PrincipalDetail principalDetail, @PathVariable int cno, Model model) throws Exception {
		
		String username = "aaa"; // 테스트용 나중엔 시큐리티 적용
		model.addAttribute("username", username);
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


	@GetMapping("/seoha/test")
	public String test() throws Exception {
		
		return "cafe/all";
	}	
	
	


}
