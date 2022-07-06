package com.pj.cherrypick.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.response.ResponseDto;
import com.pj.cherrypick.service.MemberService;

@RestController // 뷰가 아닌 데이터만 주고받는 컨트롤러
public class MemberApiController {
	
	@Autowired
	private MemberService memberService; // 스프링이 컴포넌트 스캔을 통해 MemberService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌 (=IOC 해줌)
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody MemberVO member) throws Exception {
		System.out.println("save함수 호출");
		
		MemberVO member2 = new MemberVO();
		member2.setMid(member.getMid());
		member2.setPwd(member.getPwd());
		member2.setName(member.getName());
		member2.setPhone(member.getPhone());
		member2.setEmail(member.getEmail());
		member2.setRole(0);
		
		memberService.signUp(member2); // json으로부터 member 정보 전달받아서 매개변수로 넣어줌
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1); // 1 리턴되면 성공한 것
	}
	
}
