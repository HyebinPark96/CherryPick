package com.pj.cherrypick.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service // 빈(Bean) 객체로 등록
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService{
	
	 private final MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // 매개변수 mid로 DB에서 회원 존재 유무 체크하는 메서드 =>  회원이라면 회원정보 리턴
		MemberVO principal = memberMapper.findByUsername(username);
		if (principal == null){
			throw new UsernameNotFoundException("User not authorized.");
		}
		return new PrincipalDetail(principal); // 시큐리티 세션에 회원 정보가 UserDetail 타입으로 저장됨
	}
	
	
	
}
