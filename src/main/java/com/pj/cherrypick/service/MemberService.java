package com.pj.cherrypick.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.pj.cherrypick.config.auth.PrincipalDetail;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.mapper.MemberMapper;
import com.pj.cherrypick.mapper.ReviewMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	@Autowired
	private BCryptPasswordEncoder encoder; // 암호화 방식
	
	@Transactional
	public int findDupUsername(String username) throws Exception { 
		if(memberMapper.findDupUsername(username) == 1)
			return 1; // 회원가입시 입력한 username으로 DB에 중복되는 username있는지 조회하여 있다면 1 리턴 = 중복Id
		else 
			return 0; 
	}
	
	@Transactional // 서비스 단에서 트랜잭션 시작되고 종료됨
	public void signUp(MemberVO member) throws Exception {
		String rawPassword = member.getPassword(); // 원본 비번
		String encPassword = encoder.encode(rawPassword); // 해쉬
		member.setPassword(encPassword); // 시큐리티 적용
		memberMapper.signUp(member);
	}
	
	@Transactional
	public String findUsername(String name, String email) throws Exception { // 아이디 찾기
		if(memberMapper.findUsername(name, email)==null) {
			return "";
		} else {
			return memberMapper.findUsername(name, email);
		} 
	}
	
	/* 임시비번으로 비번 재설정 후, 메일로 임시비번 전송하기 */
	
	// 임시비번 생성
	@Transactional
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
        System.out.println("tmpPassword : " + tmpPassword);
        return tmpPassword; // 임시비번 리턴
    }

    // 임시비번으로 업데이트
	@Transactional
    public void updatePassword(String tmpPassword, String username, String email) {
		
        String password = encoder.encode(tmpPassword); // 임시비번 => 해쉬로 암호화
        
        try {
        	memberMapper.updatePassword(password, username, email); // 해쉬를 비번으로 업데이트
        	System.out.println("password: " + password);

		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
	
	// DB저장된 비번과 회원수정 위해 입력한 비번 비교하기 위해 후자를 같은 방식으로 암호화 하여 비교
	@Transactional
    public boolean getEncPassword(String inputPassword, String dbPassword) {
		if(encoder.matches(inputPassword, dbPassword)) { // 입력받은 비번, 암호화된 비번
			return true;
		}
		return false;
    }
	
	
	@Transactional
	public int checkMemberOrAdmin(String username) {
		return memberMapper.checkMemberOrAdmin(username); // 0 or 1 반환
	}

	@Transactional
	public List<MemberVO> getMList() {
		List<MemberVO> mList = new ArrayList<MemberVO>();
		mList =  memberMapper.getMList();
		return mList;
	}
	
	@Transactional
	public void updateMember(MemberVO member) {
		MemberVO orgMember = memberMapper.findByUsername(member.getUsername()); // 기존 회원정보 들고오기
		
		String rawPassword = member.getPassword(); // 회원정보 수정폼에서 입력한 패스워드 가져오기
		String encPassword = encoder.encode(rawPassword); // 암호화
		
		orgMember.setPassword(encPassword); // 암호화된 비번 DB에 저장
		
		orgMember.setName(member.getName());
		orgMember.setPhone(member.getPhone());
		orgMember.setEmail(member.getEmail());
		
		memberMapper.updateMember(orgMember); // 수정 SQL문 
		
	}
	
	@Transactional
	public void updateMemberWithoutPwd(MemberVO member) {
		MemberVO orgMember = memberMapper.findByUsername(member.getUsername()); // 기존 회원정보 들고오기
		
//		String rawPassword = member.getPassword(); // 회원정보 수정폼에서 입력한 패스워드 가져오기
//		String encPassword = encoder.encode(rawPassword); // 암호화
//		
//		orgMember.setPassword(encPassword); // 암호화된 비번 DB에 저장
		
		orgMember.setName(member.getName());
		orgMember.setPhone(member.getPhone());
		orgMember.setEmail(member.getEmail());
		
		memberMapper.updateMemberWithoutPwd(orgMember); // 수정 SQL문 
		
	}
	
	// 아이디로 회원 객체 들고오기
	@Transactional
	public MemberVO findByUsername(String username) {
		return memberMapper.findByUsername(username);
	}
	
	// 아이디로 나의 리뷰 가져오기
	@Transactional
	public List<ReviewVO> getMyReviewList(String username) {
		return reviewMapper.getMyReviewList(username);
	}
	
	
}
