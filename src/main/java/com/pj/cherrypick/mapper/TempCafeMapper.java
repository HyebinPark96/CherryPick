package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;

@Repository("com.pj.cherrypick.mapper.TempCafeMapper")
@Mapper //class 말고 인터페이스 쓰기
public interface TempCafeMapper {
	
	int createCafe(CafeVO cafe);
	
	int getCafeNo();
	
	int createMenu(CafeMenuVO menu);
	
	public List<CafeVO> listCafe(String bid) throws Exception;

	public CafeVO getCafe(int cno) throws Exception;

	public List<CafeMenuVO> getCafeMenu(int cno) throws Exception;
	

}