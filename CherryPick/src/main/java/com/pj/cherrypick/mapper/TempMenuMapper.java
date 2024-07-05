package com.pj.cherrypick.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.CafeMenuVO;

@Repository("com.pj.cherrypick.mapper.TempMenuMapper")
@Mapper //class 말고 인터페이스 쓰기
public interface TempMenuMapper {
	
	int createMenu(CafeMenuVO menu);
	
}