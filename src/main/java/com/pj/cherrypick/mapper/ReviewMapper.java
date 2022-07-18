package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.ReviewVO;

@Repository("com.pj.cherrypick.mapper.ReviewMapper") // XML 위치
@Mapper // 매퍼 사용하면 빈으로 등록되므로 Service단에서 Autowired로 사용 가능
public interface ReviewMapper {
	
	List<ReviewVO> getMyReviewList(String username, int displayPost, int postNum);
	
	/*----myReview 리뷰목록 페이징 처리----*/
	// 나의 리뷰 총 갯수 : 나의 리뷰 갯수로 페이징 할거라서 매개변수로 나의 id 들어감
	public int count(String username);
	
	/*---------------------------------*/
	
	public int getHeartCnt(int rno);
	
	public void writeReviewProc(ReviewVO reviewVO);
}
