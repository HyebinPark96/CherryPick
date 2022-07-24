package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.HomeVO;

@Repository("com.pj.cherrypick.mapper.HomeMapper")
@Mapper //class 말고 인터페이스 쓰기
public interface HomeMapper {

	// 오늘의 리스트 보기
	List<HomeVO> getTodayList();
	
}
