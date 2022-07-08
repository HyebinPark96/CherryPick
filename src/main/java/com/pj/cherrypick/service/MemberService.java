package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.MailVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private BCryptPasswordEncoder encoder; // 암호화 방식
	
	@Transactional // 서비스 단에서 트랜잭션 시작되고 종료됨
	public void signUp(MemberVO member) throws Exception {
		String rawPassword = member.getPassword(); // 원본 비번
		String encPassword = encoder.encode(rawPassword); // 해쉬
		member.setPassword(encPassword); // 시큐리티 적용
		memberMapper.signUp(member);
	}
	
	@Transactional
	public String findUsername(String name, String email) throws Exception {
		return memberMapper.findUsername(name, email); // 아이디 찾기
	}
	
	/* 임시비번으로 비번 재설정 후, 메일로 임시비번 전송하기 */
	
	// 임시비번 생성
    public String getTmpPassword() {
        char[] charSet = new char[]{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String tmpPassword = "";

        /* 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 조합 */
        int idx = 0;
        for(int i = 0; i < 10; i++){
            idx = (int) (charSet.length * Math.random()); // 랜덤 정수
            tmpPassword += charSet[idx]; // 배열에서 고르기
        }

        return tmpPassword; // 임시비번 리턴
    }

    // 임시비번으로 업데이트
    public void updatePassword(String tmpPassword, String username, String email) {

        String password = encoder.encode(tmpPassword); // 임시비번 => 해쉬로 암호화
        
        try {
        	memberMapper.updatePassword(password, username, email); // 해쉬를 비번으로 업데이트
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }

	
}
