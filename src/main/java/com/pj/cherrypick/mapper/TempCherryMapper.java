package com.pj.cherrypick.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.ListVO;

@Repository("com.pj.cherrypick.mapper.TempCherryMapper")
@Mapper
public interface TempCherryMapper {
	 //class 말고 인터페이스 쓰기
		
	int addCherry(ListVO list);
	
}
