package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Transactional // 서비스 단에서 트랜잭션 시작되고 종료됨
	public void signUp(MemberVO member) throws Exception {
		memberMapper.signUp(member);
		
		System.out.println("MemberService 실행됨");
	}
}
