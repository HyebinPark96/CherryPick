package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.ListVO;

@Repository("com.pj.cherrypick.mapper.CherriesMapper")
@Mapper //class 말고 인터페이스 쓰기
public interface CherriesMapper {

	// 새롭게 등록된 체리들 불러오기
	List<ListVO> getNewCherries();
	
}
