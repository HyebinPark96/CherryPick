package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.MailService;
import com.pj.cherrypick.service.MemberService;

@RestController // 뷰가 아닌 데이터만 주고받는 컨트롤러
public class MemberApiRestController {
	
	@Autowired
	private MemberService memberService; // 스프링이 컴포넌트 스캔을 통해 MemberService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌 (=IOC 해줌)
	
	@Autowired
	private MailService mailService; 
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth/mJoinProc")
	public ResponseDto<Integer> save(@RequestBody MemberVO member) throws Exception {
		memberService.signUp(member);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1); // 1 리턴되면 성공한 것
	}
	
	@PostMapping("/auth/mUsernameCheck")
	public ResponseDto<Integer> mUsernameCheck(@RequestBody MemberVO member) throws Exception {
		int mUsernameCheck = memberService.findDupUsername(member.getUsername());
		
		if(mUsernameCheck == 0)
			return new ResponseDto<Integer>(HttpStatus.OK.value(),1); // 1 리턴되면 성공한 것
		return null;
	}
	
	@PutMapping("/member/updateMemberProc")
	public ResponseDto<Integer> updateMember(@RequestBody MemberVO member) throws Exception {
		System.out.println("member.getPassword() : " + member.getPassword());
		System.out.println("member.getPassword().length : " + member.getPassword().length());

		if(member.getPassword().length()==0) {
			System.out.println(1);
			memberService.updateMemberWithoutPwd(member); // 비번빼고 수정한 경우
			System.out.println(2);
		} else {
			System.out.println(3);
			memberService.updateMember(member); // 비번도 수정한 경우
	        /* 변경된 세션 등록 */ 
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword())); 
			SecurityContextHolder.getContext().setAuthentication(authentication);
			System.out.println(4);
		}
		
		System.out.println(5);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1); // 1 리턴되면 성공한 것
	}
}
