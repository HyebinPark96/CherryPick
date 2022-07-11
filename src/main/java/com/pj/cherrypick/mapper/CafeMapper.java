package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.CafeVO;

import lombok.NoArgsConstructor;

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
	List<CafeVO> getCafeList();
	
	
}
