package com.pj.cherrypick.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pj.cherrypick.config.auth.PrincipalDetailService;

// @Bean을 사용하는 클래스에는 반드시 @Configuration 어노테이션을 활용
@Configuration // @Configuration이 붙어있는 클래스를 자동으로 빈으로 등록해두고, 해당 클래스를 파싱해서 @Bean이 있는 메소드를 찾아서 빈을 생성해준다.
@EnableWebSecurity // 웹보안 활성화 => 시큐리티 필터 포함
@EnableGlobalMethodSecurity(prePostEnabled = true) // 메소드 수준에서 권한을 제어할 수 있도록 해준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	PrincipalDetailService principalDetailService;
	
	/*AuthenticationManager 를 외부에서 사용하기 위해, AuthenticationManagerBean 을 이용하여 Spring Securtiy 밖으로 AuthenticationManager 빼 내야 한다.*/
	@Bean // IoC
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		System.out.println("authenticationManagerBean 호출");
		return super.authenticationManagerBean();
	}
	
	
	@Bean // IoC
	public BCryptPasswordEncoder encodePWD(){ // BCryptPasswordEncoder : BCrypt 해싱 함수(BCrypt hashing function)를 사용해서 비밀번호를 인코딩해주는 메서드와 사용자의 의해 제출된 비밀번호와 저장소에 저장되어 있는 비밀번호의 일치 여부를 확인해주는 메서드를 제공
		System.out.println("encodePWD 호출");
		return new BCryptPasswordEncoder();
	}
	
	
	
	/*configure 오버라이딩해서 권한 설정*/
	
	/*password가 어떤 방식으로 해쉬값이 되어 회원가입되었는지 알아야 같은 해쉬로 암호화해서 DB에 있는 해쉬와 비교가능*/
	/* 즉, 패스워드 비교하는 메서드*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configure(AuthenticationManagerBuilder auth) 호출");
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD()); // 로그인 시 입력한 pwd를 똑같은 해시변환방식으로 변환하여 DB 해시값과 비교
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() // csrf : 정상적인 사용자가 의도치 않은 위조요청을 보내는 것을 방지하기 위한 토큰 생성을 비활성화 (테스트시 걸어두는 게 좋음)
			.authorizeRequests()
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/img/**", "/dummy/**")
				.permitAll() // 위 경로는 모든 사용자 접근 허용
				.anyRequest() // 이외의 요청들은
				.authenticated() // 인증되어야 함
			.and()
				.formLogin()
				.loginPage("/auth/loginForm") // 커스터마이징한 로그인페이지로 이동하여 로그인
				.loginProcessingUrl("/auth/loginProc") //  로그인 form 의 action 과 일치해야 하며, 스프링 시큐리티가 해당 주소로 요청하는 로그인을 가로채서 대신 로그인 진행
				// 로그인 성공시 세션에 UserDetail 타입으로 저장되어야 함. 
				// 그러나 Member Object 타입을 전달받으므로 변환과정 거쳐야 함.
				.defaultSuccessUrl("/"); // 로그인 성공하면 index로 이동
	}
}
