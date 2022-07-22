package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.domain.Page;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.service.AdminService;
import com.pj.cherrypick.service.CafeService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CafeService cafeService;

	
	/*1. 일반회원*/
	// 게시물 목록 + 페이징 추가
	@RequestMapping(value = "/admin/adminMain", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num, @RequestParam("sort") String sort,
			@RequestParam(value = "searchType", required = false, defaultValue = "id") String searchType, 
			@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
			@RequestParam(value = "orderBy", required = false, defaultValue = "") String orderBy) throws Exception{ // num : 페이지 번호
		
		Page page = new Page();
		page.setNum(num);
		
		if(sort.equals("member") && !orderBy.trim().equals("orderByRegDate")) { // 1. 일반 회원 이름순 정렬

			page.setCount(adminService.searchCount(searchType, keyword));  
			
			// 검색 타입과 검색어
			page.setSearchTypeKeyword(searchType, keyword);
			
			List<MemberVO> list = null; 
			list = adminService.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
			
			model.addAttribute("list", list);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort); 
			
			model.addAttribute("searchType", searchType);
			model.addAttribute("keyword", keyword);
			
		} else if(sort.equals("member") && orderBy.equals("orderByRegDate")) { // 2. 일반 회원 가입일자순 정렬
			page.setCount(adminService.searchCount(searchType, keyword));  
			
			// 검색 타입과 검색어
			page.setSearchTypeKeyword(searchType, keyword);
			
			List<MemberVO> list = null; 
			list = adminService.listPageSearchOrderByRegDate(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
			
			model.addAttribute("list", list);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort);
			model.addAttribute("orderBy", orderBy);
			
			model.addAttribute("searchType", searchType);
			model.addAttribute("keyword", keyword);
			
		} else if(sort.equals("authBizMember") && !orderBy.trim().equals("orderByRegDate")) { /*2. 승인 사업자 회원*/ // 3. 승인 사업자 회원 이름순 정렬
			
			BizMemberVO bizMember = new BizMemberVO();
			bizMember.setBstat(1);
			
			page.setCount(adminService.bAuthSearchCount(bizMember.getBstat(), searchType, keyword));
			
			// 검색 타입과 검색어
			page.setSearchTypeKeyword(searchType, keyword);
			
			List<BizMemberVO> list = null; 
			list = adminService.bAuthListPageSearch(bizMember.getBstat(), page.getDisplayPost(), page.getPostNum(), searchType, keyword);
			
			model.addAttribute("list", list); 
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort);
			
			model.addAttribute("searchType", searchType);
			model.addAttribute("keyword", keyword);
			
		} else if(sort.equals("authBizMember") && orderBy.trim().equals("orderByRegDate")) { // 4. 승인 사업자 회원 가입일자순 정렬
			
			BizMemberVO bizMember = new BizMemberVO();
			bizMember.setBstat(1);
			
			page.setCount(adminService.bAuthSearchCount(bizMember.getBstat(), searchType, keyword));
			
			// 검색 타입과 검색어
			page.setSearchTypeKeyword(searchType, keyword);
			
			List<BizMemberVO> list = null; 
			list = adminService.bAuthListPageSearchOrderByRegDate(bizMember.getBstat(), page.getDisplayPost(), page.getPostNum(), searchType, keyword);
			
			model.addAttribute("list", list); 
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort);
			model.addAttribute("orderBy", orderBy);
			
			model.addAttribute("searchType", searchType);
			model.addAttribute("keyword", keyword);
			
		} else if(sort.equals("unauthBizMember") && !orderBy.trim().equals("orderByRegDate")) { // 5. 미승인 사업자 회원 이름순 정렬
			
			BizMemberVO bizMember = new BizMemberVO();
			bizMember.setBstat(0);
			
			page.setCount(adminService.bUnauthSearchCount(bizMember.getBstat(), searchType, keyword));
			
			// 검색 타입과 검색어
			page.setSearchTypeKeyword(searchType, keyword);
			
			List<BizMemberVO> list = null; 
			list = adminService.bUnauthListPageSearch(bizMember.getBstat(), page.getDisplayPost(), page.getPostNum(), searchType, keyword);
			
			model.addAttribute("list", list);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort); 
			
			model.addAttribute("searchType", searchType);
			model.addAttribute("keyword", keyword);
		
		} else if(sort.equals("unauthBizMember") && orderBy.trim().equals("orderByRegDate")) { // 6. 미승인 사업자 회원 가입일자순 정렬
			
			BizMemberVO bizMember = new BizMemberVO();
			bizMember.setBstat(0);
			
			page.setCount(adminService.bUnauthSearchCount(bizMember.getBstat(), searchType, keyword));
			
			// 검색 타입과 검색어
			page.setSearchTypeKeyword(searchType, keyword);
			
			List<BizMemberVO> list = null; 
			list = adminService.bUnauthListPageSearchOrderByRegDate(bizMember.getBstat(), page.getDisplayPost(), page.getPostNum(), searchType, keyword);
			
			model.addAttribute("list", list);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort);
			model.addAttribute("orderBy", orderBy);
			
			model.addAttribute("searchType", searchType);
			model.addAttribute("keyword", keyword);
		
		} else if(sort.equals("cafe")) {
			
			page.setCount(adminService.cSearchCount(searchType, keyword));
			
			List<CafeVO> cList = null;
			cList = adminService.cafeListPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
			
			model.addAttribute("cList", cList);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort);
			
			model.addAttribute("searchType", searchType);
			model.addAttribute("keyword", keyword);
			
		}

		
	}
	
	@GetMapping("/admin/adminReview/{cno}")
	public String adminReview(@PathVariable int cno, @RequestParam("num") int num, Model model) throws Exception { 
		
		Page page = new Page();
		page.setNum(num);
		
		page.setCount(adminService.rCount(cno));
		// System.out.println("rCount : " + adminService.rCount(cno));
		
		List<ReviewVO> rList = null;
		rList = adminService.getReviewList(cno, page.getDisplayPost(), page.getPostNum());
		
		CafeVO cafe = adminService.getCafeInfo(cno);
		
		model.addAttribute("cno", cno);
		model.addAttribute("rList", rList);
		model.addAttribute("cafe", cafe);
		model.addAttribute("page", page);
		model.addAttribute("select", num);
		
		return "admin/adminReview";
	}
	
	@GetMapping("/admin/adminReviewView/{cno}")
	public String adminReviewView(@PathVariable int cno, @RequestParam("rno") int rno, Model model) throws Exception {
		
		ReviewVO review = null;
		review = adminService.getOneReview(rno);
		
		model.addAttribute("review", review);
		
		return "admin/adminReviewView";
	}
	
}
