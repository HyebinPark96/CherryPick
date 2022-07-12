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

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.BizMemberService;
import com.pj.cherrypick.service.MailService;

@RestController
public class BizMemberApiRestController {
	
	@Autowired
	private BizMemberService bizMemberService; // 스프링이 컴포넌트 스캔을 통해 MemberService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌 (=IOC 해줌)
	
	@Autowired
	private MailService mailService; 
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth/bJoinProc")
	public ResponseDto<Integer> save(@RequestBody BizMemberVO bizMember) throws Exception {
		bizMemberService.signUp(bizMember);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1); // 1 리턴되면 성공한 것
	}
	
	@PostMapping("/auth/bUsernameCheck")
	public ResponseDto<Integer> bUsernameCheck(@RequestBody BizMemberVO bizMember) throws Exception {
		int bUsernameCheck = bizMemberService.findDupUsername(bizMember.getUsername());
		if(bUsernameCheck == 0)
			return new ResponseDto<Integer>(HttpStatus.OK.value(),1); // 1 리턴되면 성공한 것
		return null;
	}
	
	@PutMapping("/member/updateBMemberProc")
	public ResponseDto<Integer> updateBizMember(@RequestBody BizMemberVO bizMember) throws Exception {
		System.out.println("bMember.getPassword() : " + bizMember.getPassword());
		System.out.println("bMember.getPassword().length : " + bizMember.getPassword().length());

		if(bizMember.getPassword().length()==0) {
			bizMemberService.updateMemberWithoutPwd(bizMember); // 비번빼고 수정한 경우
		} else {
			bizMemberService.updateMember(bizMember); // 비번도 수정한 경우
	        /* 변경된 세션 등록 */ 
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(bizMember.getUsername(), bizMember.getPassword())); 
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1); // 1 리턴되면 성공한 것
	}
}
