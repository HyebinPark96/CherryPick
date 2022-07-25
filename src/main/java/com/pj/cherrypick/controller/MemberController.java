package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.cherrypick.config.auth.PrincipalDetail;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.domain.Page;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.service.CafeService;
import com.pj.cherrypick.service.MemberService;
import com.pj.cherrypick.service.ReviewService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService; // 스프링이 컴포넌트 스캔을 통해 MemberService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌 (=IOC 해줌)
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private CafeService cafeService;
	
	// http://localhost/auth/selectTypeForFindId
	@GetMapping("/auth/selectTypeForFindId")
	public String selectTypeForFindId() {
		return "selectTypeForFindId"; // /WEB-INF/views/templates/selectTypeForFindId
	}
	
	// http://localhost/auth/selectTypeForFindPwd
	@GetMapping("/auth/selectTypeForFindPwd")
	public String selectTypeForFindPwd() {
		return "selectTypeForFindPwd"; // /WEB-INF/views/templates/selectTypeForFindPwd
	}
	
	// http://localhost/auth/joinForm
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "joinForm"; // /WEB-INF/views/templates/joinForm
	}
	
	@GetMapping("/auth/loginForm")
	// http://localhost/auth/loginForm
	public String loginForm() {
		return "loginForm"; // /WEB-INF/views/templates/loginForm
	}
	
	@GetMapping("/auth/findUsernameForm")
	// http://localhost/auth/findIdForm
	public String findUsernameForm() {
		return "member/findUsernameForm"; // /WEB-INF/views/templates/member/findIdForm
	}
	
	@GetMapping("/auth/findPasswordForm")
	// http://localhost/auth/findPasswordForm
	public String findPasswordForm() {
		return "member/findPasswordForm"; // /WEB-INF/views/templates/member/findPwdForm
	}
	
	@GetMapping("/member/memberEditForm")
	// http://localhost/member/memberEditForm
	public String memberEditForm(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
		MemberVO member = memberService.findByUsername(principalDetail.getUsername());
		model.addAttribute("member", member);
		return "member/memberEditForm"; // /WEB-INF/views/templates/member/memberEditForm
	}
	
	@GetMapping("/member/checkPwdForEdit")
	// http://localhost/member/checkPwdForEdit
	public String checkPwdForEdit() {
		return "member/checkPwdForEdit"; // /WEB-INF/views/templates/member/checkPwdForEdit
	}
	
	@GetMapping("/member/myReview")
	// http://localhost/member/myReview
	public void myReview(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model, 
			@RequestParam("num") int num) {
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(reviewService.count(principalDetail.getUsername())); 
		
		List<ReviewVO> myReviewList = null;
		myReviewList = memberService.getMyReviewList(principalDetail.getUsername(), page.getDisplayPost(), page.getPostNum());
		
		model.addAttribute("list", myReviewList);
		model.addAttribute("page", page);
		model.addAttribute("select", num); // 현재 페이지 (현재 페이지가 아닌 페이지와 구분하기 위해 값 전달)
		
	}
	
	@GetMapping("/auth/checkPwdForEditResult")
	public String checkPwdForEditResult() {
		return "member/checkPwdForEditResult";
	}
	
	@GetMapping("/member/myPage")
	public String getMyCafeBmk(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
		MemberVO member = memberService.findByUsername(principalDetail.getUsername()); // 회원 정보 가져오기
		String username = principalDetail.getUsername();
		List<CafeVO> cafes = cafeService.getMyCafeBmk(username);
		List<ListVO> list = cafeService.getMyListBmk(username);
		model.addAttribute("cafes", cafes);
		model.addAttribute("list", list);
		model.addAttribute("member", member); // 뷰에 보내기
		return "member/myPage";
	}
	
	/*CafeController에서 MemberController 의 위 메소드로 이동*/
//	@GetMapping("/member/myPage")
//	public String getMyCafeBmk(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
//		String username = principalDetail.getUsername();
//		List<CafeVO> cafes = cafeService.getMyCafeBmk(username);
//		List<ListVO> list = cafeService.getMyListBmk(username);
//		model.addAttribute("cafes", cafes);
//		model.addAttribute("list", list);
//		return "/member/myPage";
//	}

	@GetMapping("/member/withdrawal")
	public String withdrawal() {
		return "member/withdrawal";
	}
	
	
	@GetMapping("/member/myAddCherry")
	public String myAddCherry(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model) {
		MemberVO member = memberService.findByUsername(principalDetail.getUsername()); // 회원 정보 가져오기
		model.addAttribute("member", member);
		
		return "member/myAddCherry";
	}
	
}