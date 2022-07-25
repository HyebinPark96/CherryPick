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
	
	// SELECT 전체 회원 목록 출력 (가입일자순)
	public List<MemberVO> listPageSearchOrderByRegDate(String searchType, String keyword);
	
	// 삭제
	public void delete(String username) throws Exception;
	
	// 총 갯수
	public int count() throws Exception;
	
	// 총 갯수
	public int searchCount(String searchType, String keyword) throws Exception;
	
	// 회원탈퇴
	public void withdrawalForMem(String username[]);
	
	// 목록 + 페이징
	public List<MemberVO> listPage(int displayPost, int postNum) throws Exception;
	
	// 목록 + 페이징 + 검색 : 이름순 정렬
	public List<MemberVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	// 목록 + 페이징 + 검색 : 가입일자순 정렬
	public List<MemberVO> listPageSearchOrderByRegDate(int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	
	/*2. 사업자회원*/
	
	// 승인 사업자 회원 리스트
	public List<BizMemberVO> bAuthList() throws Exception;
	
	// 미승인 사업자 회원 리스트
	public List<BizMemberVO> bUnauthList() throws Exception;
	
	// 삭제
	public void bDelete(String username) throws Exception;
	
	// 승인 사업자 회원 수
	public int bAuthCount(int bstat) throws Exception;
	
	// 승인 사업자 회원 수
	public int bAuthSearchCount(int bstat, String searchType, String keyword) throws Exception;
	
	// 미승인 사업자 회원 수
	public int bUnauthCount(int bstat) throws Exception;
	
	// 미승인 사업자 회원 수
	public int bUnauthSearchCount(int bstat, String searchType, String keyword) throws Exception;
	
	// 회원탈퇴
	public void withdrawalForAuthBiz(String bid[]) throws Exception;
	
	// 승인취소
	public void cancleApproval(String bid) throws Exception;
	
	// 승인
	public void approval(String bid) throws Exception;
	
	// 선택 승인
	public void checkApproval(String bid[]) throws Exception;
	
	// 목록 + 페이징
	public List<BizMemberVO> bAuthListPage(int bstat, int displayPost, int postNum) throws Exception;
	
	// 목록 + 페이징 + 검색
	public List<BizMemberVO> bAuthListPageSearch(int bstat, int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	// 목록 + 페이징 + 검색 : 가입일자 내림차순 정렬
	public List<BizMemberVO> bAuthListPageSearchOrderByRegDate(int bstat, int displayPost, int postNum, String searchType, String keyword) throws Exception;

	// 목록 + 페이징
	public List<BizMemberVO> bUnauthListPage(int bstat, int displayPost, int postNum) throws Exception;
	
	// 목록 + 페이징 + 검색
	public List<BizMemberVO> bUnauthListPageSearch(int bstat, int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	// 목록 + 페이징 + 검색 : 가입일자 내림차순 정렬
	public List<BizMemberVO> bUnauthListPageSearchOrderByRegDate(int bstat, int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	/*사업장 관리*/
	// 사업장 리스트
	public List<CafeVO> cafeList() throws Exception;
	
	// 목록 + 페이징
	public List<CafeVO> cafeListPage(int displayPost, int postNum) throws Exception;
	
	// 목록 + 페이징 + 검색
	public List<CafeVO> cafeListPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception;
	
	// 사업장 총 갯수
	public int cCount() throws Exception;
	
	// 사업장 총 갯수
	public int cSearchCount(String searchType, String keyword) throws Exception;
	
	// 사업장별 리뷰 가져오기
	public List<ReviewVO> getReviewList(int cno, int displayPost, int postNum);
	
	// 검색한 사업장별 리뷰 가져오기 
	public List<ReviewVO> getReviewListSearch(int cno, int displayPost, int postNum, String searchType, String keyword);
	
	// 리뷰 총 갯수
	public int rCount(int cno) throws Exception; 
	
	// 검색 리뷰 총 갯수
	public int rSearchCount(int cno, String searchType, String keyword) throws Exception; 
	
	// 사업장별 리뷰에서 사업장 정보 가져오기
	public CafeVO getCafeInfo(int cno)  throws Exception;
	
	// 특정 사업장 리뷰 1개 상세보기
	public ReviewVO getOneReview(int rno)  throws Exception;
	
	// 리뷰 삭제
	public void adminReviewDelete(int rno[]) throws Exception;
	
}
