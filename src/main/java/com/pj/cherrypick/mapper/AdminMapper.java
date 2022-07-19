package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.domain.ReviewVO;

@Repository("com.pj.cherrypick.mapper.AdminMapper") // XML 위치
@Mapper // 매퍼 사용하면 빈으로 등록되므로 Service단에서 Autowired로 사용 가능
public interface AdminMapper {
	
	/*1. 일반회원*/
	// 리스트
	public List<MemberVO> list() throws Exception;
	
	// 삭제
	public void delete(String username) throws Exception;
	
	// 총 갯수
	public int count() throws Exception;
	
	// 목록 + 페이징
	public List<MemberVO> listPage(int displayPost, int postNum) throws Exception;

	
	/*2. 사업자회원*/
	
	// 승인 사업자 회원 리스트
	public List<BizMemberVO> bAuthList() throws Exception;
	
	// 미승인 사업자 회원 리스트
	public List<BizMemberVO> bUnauthList() throws Exception;
	
	// 삭제
	public void bDelete(String username) throws Exception;
	
	// 승인 사업자 회원 수
	public int bAuthCount(int bstat) throws Exception;
	
	// 미승인 사업자 회원 수
	public int bUnauthCount(int bstat) throws Exception;
	
	// 목록 + 페이징
	public List<BizMemberVO> bAuthListPage(int bstat, int displayPost, int postNum) throws Exception;
	
	// 목록 + 페이징
	public List<BizMemberVO> bUnauthListPage(int bstat, int displayPost, int postNum) throws Exception;
	
	/*사업장 관리*/
	// 사업장 리스트
	public List<CafeVO> cafeList() throws Exception;
	
	// 목록 + 페이징
	public List<CafeVO> cafeListPage(int displayPost, int postNum) throws Exception;
	
	// 사업장 총 갯수
	public int cCount() throws Exception;
	
	// 사업장별 리뷰 가져오기
	public List<ReviewVO> getReviewList(int cno, int displayPost, int postNum);
	
	// 리뷰 총 갯수
	public int rCount() throws Exception; 
	
	// 사업장별 리뷰에서 사업장 정보 가져오기
	public CafeVO getCafeInfo(int cno);
	
}
