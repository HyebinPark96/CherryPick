package com.pj.cherrypick.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pj.cherrypick.config.auth.PrincipalDetail;
import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.BizMemberService;
import com.pj.cherrypick.service.MailService;

@Controller
public class BizMemberApiController {
	@Autowired
	private BizMemberService bizMemberService; // 스프링이 컴포넌트 스캔을 통해 MemberService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌 (=IOC 해줌)
	
	@Autowired
	private MailService mailService; 
	
	@PostMapping("/auth/bizFindUsernameProc")
	public String findUsername(@RequestParam("bname") String bname, @RequestParam("bemail") String bemail, Model model) throws Exception {
//		System.out.println("name : " + name);
//		System.out.println("email : " + email);
		
		/*아이디 3자리 이후부터 잘라 *로 처리하기*/
		String rawUsername = bizMemberService.findUsername(bname, bemail);
		int rawUsernameLen = rawUsername.length(); // 아이디 글자수
		String rawUsernameStart = rawUsername.substring(0, 3); // 시작위치, 종료위치 // 그대로 나타낼 부분
		String rawUsernameEnd = rawUsername.substring(3, rawUsernameLen); // * 표시할 부분
		
		String encUsernameEnd = "";
		for (int i = 0; i < rawUsernameEnd.length(); i++) {
			encUsernameEnd+="*"; // * 처리
		}

		String encUsername = rawUsernameStart + encUsernameEnd; // 일부 *로 변환된 아이디
		
//		System.out.println("encUsername : " + encUsername);
		
		model.addAttribute("username", encUsername);
		return "bizMember/findUsernameResult";
	}
	
	@PostMapping("/auth/bizSendEmailProc")
	public String sendEmailProc(@RequestParam("username") String username, @RequestParam("bemail") String bemail, Model model) {
		BizMemberVO bizmember = bizMemberService.findByUsername(username);
		
		if(!bemail.equals(bizmember.getBemail())) {
			return "member/findPasswordResult";
		} else {
			String tmpPassword = bizMemberService.getTmpPassword(); // 임시비번 생성
			
			bizMemberService.updatePassword(tmpPassword, username, bemail); // Service단에 임시비번 전달하면 해쉬로 암호화 거쳐서 업데이트해줌
			
			mailService.sendEmail(bemail, tmpPassword); // 이메일로 임시비번 전송
			
			return "loginForm";
		}
	}
		
		@PostMapping("/bizMember/checkPwdForEditResult")
		public String checkPwdForEditResult(@AuthenticationPrincipal PrincipalDetail principalDetail/*스프링 시큐리티 세션의 username을 들고온다.*/,@RequestParam(required = false, value = "password") String password, Model model) {
			System.out.println("password"+password);
			BizMemberVO bizMember = bizMemberService.findByUsername(principalDetail.getUsername()); // DB 저장된 회원정보 가져오기
			boolean checkPassword = bizMemberService.getEncPassword(password, bizMember.getPassword());
			
			if(!checkPassword) {
				System.out.println("false");
				return "bizMember/checkPwdForEditResult";
			} else {
				System.out.println("true");
				model.addAttribute("bizMember", bizMember); // member 객체들고 뷰로 이동
				return "bizMember/memberEditForm";
			}
		}
		
		@PostMapping("/auth/bSignInProc")
		public String signIn(@RequestParam String username, @RequestParam String password, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
			HttpSession session = request.getSession();
			BizMemberVO bizMember = bizMemberService.signIn(username, password);
			System.out.println(bizMember.getUsername());
			System.out.println(bizMember.getPassword());
			String failMessage = "아이디 혹은 비밀번호가 잘못 되었습니다."; // 로그인 실패 알림 문구
			if(bizMember.equals(null) || bizMember == null) { // 회원정보 없음 => 로그인 실패
		        rttr.addFlashAttribute("loginFail", failMessage);
		        return "redirect:/loginForm";
			} else {
			    session.setAttribute("signInBizMember", bizMember);
			    return "redirect:/";
			}
		}
	
}
