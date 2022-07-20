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
import com.pj.cherrypick.service.ReviewService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CafeService cafeService;

	
	/*1. 일반회원*/
	// 게시물 목록 + 페이징 추가
	@RequestMapping(value = "/admin/adminMain", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num, @RequestParam("sort") String sort) throws Exception{ // num : 페이지 번호
		Page page = new Page();
		page.setNum(num);
		
		if(sort.equals("member")) {
			
			page.setCount(adminService.count());  

			List<MemberVO> list = null; 
			list = adminService.listPage(page.getDisplayPost(), page.getPostNum());
			
			model.addAttribute("list", list);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort); 
			
		} else if(sort.equals("authBizMember")) { /*2. 승인 사업자 회원*/
			
			BizMemberVO bizMember = new BizMemberVO();
			bizMember.setBstat(1);
			
			page.setCount(adminService.bAuthCount(bizMember.getBstat()));
			
			List<BizMemberVO> list = null; 
			list = adminService.bAuthListPage(bizMember.getBstat(), page.getDisplayPost(), page.getPostNum());
			
			model.addAttribute("list", list); 
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort); 
			
		} else if(sort.equals("unauthBizMember")) { /*3. 미승인 사업자 회원*/
			
			BizMemberVO bizMember = new BizMemberVO();
			bizMember.setBstat(0);
			
			page.setCount(adminService.bUnauthCount(bizMember.getBstat()));
			
			List<BizMemberVO> list = null; 
			list = adminService.bUnauthListPage(bizMember.getBstat(), page.getDisplayPost(), page.getPostNum());
			
			model.addAttribute("list", list);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort); 
		
		} else if(sort.equals("cafe")) {
			
			page.setCount(adminService.cCount());  

			List<CafeVO> cList = null;
			cList = adminService.cafeListPage(page.getDisplayPost(), page.getPostNum());
			
			model.addAttribute("cList", cList);
			model.addAttribute("page", page);
			model.addAttribute("select", num);
			model.addAttribute("sort", sort);
		}

		
	}
	
	@GetMapping("/admin/adminReview/{cno}")
	public String adminReview(@PathVariable int cno, @RequestParam("num") int num, Model model) throws Exception { 
		
		Page page = new Page();
		page.setNum(num);
		
		page.setCount(adminService.rCount());  
		
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
	public String adminReviewView(@PathVariable int cno, @RequestParam("rno") int rno) {
		
		return "admin/adminReviewView";
	}
	
}
