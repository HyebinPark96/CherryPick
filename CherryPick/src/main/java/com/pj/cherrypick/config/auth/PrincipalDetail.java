package com.pj.cherrypick.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.MemberVO;

import lombok.Getter;

@Getter // 리뷰 글쓰기에 필요한 member Composition 꺼내기 위해 사용
public class PrincipalDetail implements UserDetails { // 세션 저장하려면 UserDetail 형식만 가능 => UserDetail 인터페이스 구현하고, 그에 따른 추상메소드는 오버라이딩 필요
	
	/*Composition*/
	private MemberVO member; // 부모와 강한 의존과 결합을 가진 '상속'의 단점을 보완하기 위해 'Composition' 사용

	/*생성자*/
	public PrincipalDetail(MemberVO member) {
		this.member = member;
	}
	
	/* 추상메소드 오버라이딩 */
	
	@Override
	public String getPassword() { 
		return member.getPassword(); // password 리턴
	}

	@Override
	public String getUsername() {
		return member.getUsername(); // Id 리턴
	}

	@Override
	public boolean isAccountNonExpired() { // 만료 유무 리턴 (true : 만료안됨)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 계정 잠김 유무 리턴 (true : 잠기지 않음)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 비밀번호 만료 유무 리턴 (true : 만료안됨)
		return true;
	}

	@Override
	public boolean isEnabled() { // 계정 활성화 유무 리턴 (true : 활성화)
		return true;
	} 

	// 계정의 권한 목록을 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>(); // ArrayList 는 Collection의 자식이므로 가능한 코드
		
		// Java는 메소드를 매개변수로 넣을 수 없으나 Java8부터 사용가능한 람다식 사용하면 가능
		collectors.add(()->{return "ROLE_" + member.getRole();}); 
		
		return collectors;
	}
}
