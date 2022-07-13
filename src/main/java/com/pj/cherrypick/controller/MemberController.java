package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.cherrypick.config.auth.PrincipalDetail;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.mapper.MemberMapper;
import com.pj.cherrypick.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService; // 스프링이 컴포넌트 스캔을 통해 MemberService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌 (=IOC 해줌)
	
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
	
	@GetMapping("/member/myPage")
	// http://localhost/member/myPage
	public String myPage() {
		return "member/myPage"; // /WEB-INF/views/templates/member/myPage
	}
	
	@GetMapping("/admin/adminMain")
	//  http://localhost/admin/adminMain
	public String adminMain(@AuthenticationPrincipal PrincipalDetail principalDetail/*스프링 시큐리티 세션의 username을 들고온다.*/, Model model) {
		try {
			// 관리자가 로그인하면 헤더에 있는 adminMain 카테고리로 접근 가능하지만,
			// 회원이 url로 접근할 수 있으므로, 이를 방지하기 위해 멤버인지 관리자인지 체크하는 서비스 필요
			if(memberService.checkMemberOrAdmin(principalDetail.getUsername())==0) { // role=0 : 관리자
				// 회원이라 접근권한 없을 경우
				return "error/403"; // /WEB-INF/views/templates/error/403
			};
			List<MemberVO> mList = memberService.getMList();
			model.addAttribute("mList", mList); // model 을 들고 view 까지 이동
		} catch (Exception e) {
			if(principalDetail==null) {
				// 비회원일 경우
				return "redirect:/loginForm"; // /WEB-INF/views/templates/loginForm
			}
		}
		return "admin/adminMain";
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
	
	@GetMapping("/error/403")
	// http://localhost/error/403
	public String ForbiddenErrorPage() {
		return "error/403"; // /WEB-INF/views/templates/error/403
	}
	
	@GetMapping("/error/404")
	// http://localhost/error/403
	public String notFoundErrorPage() {
		return "error/404"; // /WEB-INF/views/templates/error/404
	}
	
	@GetMapping("/error/500")
	// http://localhost/error/500
	public String internalServerErrorPage() {
		return "error/500"; // /WEB-INF/views/templates/error/500
	}
	
	@GetMapping("/member/myReview")
	// http://localhost/member/myReview
	public String myReview() {
		return "member/myReview"; // /WEB-INF/views/templates/member/myReview
	}

}