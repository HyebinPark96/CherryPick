package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.domain.ReviewVO;

@Repository("com.pj.cherrypick.mapper.CafeMapper")
@Mapper //class 말고 인터페이스 쓰기
public interface CafeMapper {
	

	
	int createCafe(CafeVO cafe);
	
	int updateCafe(CafeVO cafe);
	
	int deleteCafe(int cno);
	
	// 특정카페(cno) 상세정보 불러오기
	CafeVO getCafeInfo(int cno);
	
	// 전체 카페 보기
	List<CafeVO> getCafeAll();
	
	// 특정카페(cno) 리뷰 1개씩만 리스트로 불러오기 (미리보기)
	ReviewVO getFirstReview(int cno);
	
	// 특정리스트(lino) 보기
	ListVO getEachList(int lino);
	
	// 특정리스트(lino)에 포함된 카페 리스트 보기
	List<CafeVO> getCafeList(int cno);
	
	// 특정카페(cno) 메뉴판 불러오기
	List<CafeMenuVO> getCafeMenu(int cno);
	
	// 특정카페(cno) 리뷰 전체리스트로 불러오기
	List<ReviewVO> getReview(int cno);
	
}