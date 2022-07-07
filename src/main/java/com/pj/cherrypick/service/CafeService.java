package com.pj.cherrypick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.mapper.CafeMapper;

@Service
public class CafeService {
	
	@Autowired
	private CafeMapper cafeMapper;
	
	public CafeVO getCafe(int cno) {
		return cafeMapper.getCafe(cno);
	}
	
	public List<CafeVO> getCafeList() {
		return cafeMapper.getCafeList();
	}
	
	public int createCafe(CafeVO cafe) {
		return cafeMapper.createCafe(cafe);
	}
	
	public int updateCafe(CafeVO cafe) {
		return cafeMapper.updateCafe(cafe);
	}
	
	public int deleteCafe(int cno) {
		return cafeMapper.deleteCafe(cno);
	}
	

	
}
