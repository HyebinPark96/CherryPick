package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ReviewVO;

@Repository("com.pj.cherrypick.mapper.CafeMapper")
@Mapper //class 말고 인터페이스 쓰기
public interface CafeMapper {
	
	CafeVO getCafe(int cno);
	
	int createCafe(CafeVO cafe);
	
	int updateCafe(CafeVO cafe);
	
	int deleteCafe(int cno);
	
	// 특정카페(cno) 상세정보 불러오기
	CafeVO getCafeDetail(int cno);
	
	// 카페 리스트업 
	List<CafeVO> getCafePreviewList();
	
	// 특정카페(cno) 리뷰 1개씩만 리스트로 불러오기 (미리보기)
	ReviewVO getFirstReview(int cno);
	
	
}
