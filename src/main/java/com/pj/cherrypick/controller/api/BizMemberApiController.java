package com.pj.cherrypick.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.service.BizMemberService;
import com.pj.cherrypick.service.MailService;

@Controller
public class BizMemberApiController {
	@Autowired
	private BizMemberService bizMemberService; // 스프링이 컴포넌트 스캔을 통해 MemberService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌
												// (=IOC 해줌)

	@Autowired
	private MailService mailService;

	@PostMapping("/auth/findBidProc")
	public String findUsername(@RequestParam String bname, @RequestParam String bemail, Model model)
			throws Exception {

		/*null 방지*/
		if(bizMemberService.findBid(bname, bemail).trim().equals("")) {
			model.addAttribute("bid","");
			return "bizMember/findUsernameResult";
		}
		
		/* 아이디 3자리 이후부터 잘라 *로 처리하기 */
		String rawUsername = bizMemberService.findBid(bname, bemail);
		
		int rawUsernameLen = rawUsername.length(); // 아이디 글자수
		String rawUsernameStart = rawUsername.substring(0, 3); // 시작위치, 종료위치 // 그대로 나타낼 부분
		String rawUsernameEnd = rawUsername.substring(3, rawUsernameLen); // * 표시할 부분

		String encUsernameEnd = "";
		for (int i = 0; i < rawUsernameEnd.length(); i++) {
			encUsernameEnd += "*"; // * 처리
		}

		String encUsername = rawUsernameStart + encUsernameEnd; // 일부 *로 변환된 아이디

		model.addAttribute("bid", encUsername);
		return "bizMember/findUsernameResult";
	}

	@PostMapping("/auth/sendBemailProc")
	public String sendEmailProc(@RequestParam String bid, @RequestParam String bemail,
			Model model) {
		
		try {
			if(bid.trim().equals("") || bemail.trim().equals("")) {
				model.addAttribute("result",""); // 공백 입력한 경우
				return "bizMember/findPasswordResult";
			}
			
			if(bizMemberService.findByUsername(bid)==null) {
				model.addAttribute("result", "null"); // 아이디 없는 경우
				return "bizMember/findPasswordResult";
			}else {
				BizMemberVO bizMember = bizMemberService.findByUsername(bid);
		
				if (!bemail.equals(bizMember.getBemail())) {
					model.addAttribute("result", "null"); // 아이디는 있는데, 이메일 주소 다른 경우
					return "bizMember/findPasswordResult";
				} else {
					String tmpPassword = bizMemberService.getTmpPassword(); // 임시비번 생성
		
					bizMemberService.updatePassword(tmpPassword, bid, bemail); // Service단에 임시비번 전달하면 해쉬로 암호화 거쳐서 업데이트해줌
		
					mailService.sendEmail(bemail, tmpPassword); // 이메일로 임시비번 전송
					
					return "loginForm";
				}
			}
		} catch (Exception e) {
			return "/error/500";
		}
	}

	@PostMapping("/bizMember/checkPwdForEdit")
	public String checkPwdForEdit(@SessionAttribute(name = "bizMember", required = false) BizMemberVO bizMember, Model model) {
		model.addAttribute("bizMember", bizMember);
		return "bizMember/checkPwdForEdit"; // model 들고 뷰로 이동
	}

	@PostMapping("/bizMember/checkPwdForEditResult")
	public String checkPwdForEditResult(@RequestParam(required = false, value = "bid") String bid,
			@RequestParam(required = false, value = "bpwd") String bpwd, Model model) {
		BizMemberVO bizMember = bizMemberService.findByUsername(bid); // DB 저장된 회원정보 가져오기
		boolean checkEqualsPassword = bizMemberService.checkEqualsPassword(bpwd, bizMember.getBpwd()); // DB비번 입력비번 일치여부

		if (!checkEqualsPassword) { // 일치하지 않는다면 
			return "bizMember/checkPwdForEditResult";
		} else { 
			model.addAttribute("bizMember", bizMember); // bizMember 객체들고 뷰로 이동
			return "bizMember/memberEditForm";
		}
	}

	@PostMapping("/auth/bSignInProc")
	public String signIn(@RequestParam String bid, @RequestParam String bpwd, HttpServletRequest request, Model model) throws Exception {
		
		HttpSession session = request.getSession();
		
		if(bizMemberService.signIn(bid, bpwd)!=null) { // 로그인 성공
			BizMemberVO bizMember = bizMemberService.signIn(bid, bpwd); // 로그인 성공
			session.setAttribute("bizMember", bizMember);
			return "redirect:/";
		} else { // 로그인 실패
			model.addAttribute("alertFailMsg", "해당 회원정보가 없습니다.");
			return "loginForm";
		}
	}

	@PostMapping(value = "/bizMember/signOut")
	public String signOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/";
	}

	@PostMapping(value = "/bizMember/myPage")
	public String myPage(@SessionAttribute(name = "bizMember", required = false) BizMemberVO bizMember, Model model) {
		model.addAttribute("bizMember", bizMember);
		return "bizMember/myPage"; // model 들고 뷰로 이동
	}
	
	@PostMapping("/bizMember/storeManagement")
	public String storeManagement(@SessionAttribute(name = "bizMember", required = false) BizMemberVO bizMember, Model model) {
		model.addAttribute("bizMember", bizMember);
		return "bizMember/storeManagement"; // model 들고 뷰로 이동
	}

}
