package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.CafeVO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Repository("com.pj.cherrypick.mapper.CafeMapper")
@Mapper //class 말고 인터페이스 쓰기
public interface CafeMapper {
	
	CafeVO getCafe(int cno);
	
	List<CafeVO> getCafeList();
	
	int createCafe(CafeVO cafe);
	
	int updateCafe(CafeVO cafe);
	
	int deleteCafe(int cno);
	

	
}
