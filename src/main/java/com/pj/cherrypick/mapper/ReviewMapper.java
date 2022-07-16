package com.pj.cherrypick.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.HeartVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.domain.ReviewVO;

@Repository("com.pj.cherrypick.mapper.ReviewMapper") // XML 위치
@Mapper // 매퍼 사용하면 빈으로 등록되므로 Service단에서 Autowired로 사용 가능
public interface ReviewMapper {
	
	List<ReviewVO> getMyReviewList(String username, int displayPost, int postNum);
	
	/*myReview 리뷰목록 페이징 처리*/
	// 1. 나의 리뷰 총 갯수 : 나의 리뷰 갯수로 페이징 할거라서 매개변수로 나의 id 들어감
	public int count(String username);
	
	// 테이블 4개 조인해야 모든 정보 출력 가능하므로
	// 2. 리뷰 관련 리스트 
	public List<MemberVO> mList();
	public List<CafeVO> cList();
	public List<ReviewVO> vList();
	public List<HeartVO> hList();
	
}
