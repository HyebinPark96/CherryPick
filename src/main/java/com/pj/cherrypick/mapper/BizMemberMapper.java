package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.MemberVO;

@Repository("com.pj.cherrypick.mapper.BizMemberMapper") // XML 위치
@Mapper // 매퍼 사용하면 빈으로 등록되므로 Service단에서 Autowired로 사용 가능
public interface BizMemberMapper {
	
	// (테스트용) SELECT 전체 회원 목록 출력
	List<BizMemberVO> getBMList();
	
	// INSERT 회원가입
	void signUp(BizMemberVO bizMember) throws Exception;
	
	// Optional로 객체를 감싸서 사용하면 NPE를 유발할 수 있는 null을 직접 다루지 않아도 됨
	// SELECT 로그인시 입력한 ID로 회원 유무 체크
	BizMemberVO findByBid(String bid);
	
	// SELECT 아이디 찾기시 입력한 이름과 이메일로 아이디 리턴
	String findBid(String bname, String bemail);
	
	// 해당 아이디와 이메일 가진 사람이 있는지 체크 (0 리턴 : 없음, 1 리턴 : 존재)
	int findBpwdCheck(String bid, String bemail);
	
	// 비밀번호만 수정
	void updateBpwd(String bpwd, String bid, String bemail);
	
	// 아이디 찾기
	int findDupBid(String bid);
	
//	// 회원인지 관리자인지 구분 : 관리자 이외 사람이 url로 관리자 페이지 접근하는 것 방지하기 위해 
//	int checkMemberOrAdmin(String username);
	
	void updateBMember(BizMemberVO bizMember);
	
	// 비밀번호 빼고 수정
	void updateBMemberWithoutPwd(BizMemberVO bizMember);
	
	BizMemberVO signIn(String bid, String bpwd);
}
