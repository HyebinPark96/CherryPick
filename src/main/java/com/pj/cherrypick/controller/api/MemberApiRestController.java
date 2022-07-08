package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody MemberVO member) throws Exception {
		memberService.signUp(member);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1); // 1 리턴되면 성공한 것
	}
	
	@PostMapping("/auth/sendEmailProc")
	public ResponseDto<Integer> sendEmailProc(@RequestParam String username, @RequestParam String email) {
		String tmpPassword = memberService.getTmpPassword(); // 임시비번 생성
		System.out.println("sendEmail Controller 실행1");
		
		memberService.updatePassword(tmpPassword, username, email); // Service단에 임시비번 전달하면 해쉬로 암호화 거쳐서 업데이트해줌
		System.out.println("sendEmail Controller 실행2");
		
		mailService.sendEmail(email, tmpPassword); // 이메일로 임시비번 전송
		
		System.out.println("sendEmail Controller 실행3");
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
}
