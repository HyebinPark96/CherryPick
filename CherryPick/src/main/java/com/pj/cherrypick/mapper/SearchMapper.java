package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.FilterVO;
import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.domain.ReviewVO;

@Repository("com.pj.cherrypick.mapper.SearchMapper")
@Mapper //class 말고 인터페이스 쓰기
public interface SearchMapper {
	
	// 이름으로 카페 검색
	List<CafeVO> getCafeByName(String keyword, FilterVO filter);
	
	// 해시태그로 카페 검색
	List<CafeVO> getCafeByTag(String keyword, FilterVO filter);
	
	// 이름으로 카페 리스트 검색
	List<ListVO> getListByName(String keyword, FilterVO filter);
}