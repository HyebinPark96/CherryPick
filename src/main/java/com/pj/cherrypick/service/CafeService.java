package com.pj.cherrypick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.mapper.CafeMapper;

@Service
public class CafeService {
	
	@Autowired
	private CafeMapper cafeMapper;
	
	public CafeVO getCafe(int cno) {
		return cafeMapper.getCafe(cno);
	}
	
	public List<CafeVO> getCafePreviewList() {
		return cafeMapper.getCafePreviewList();
	}
	
	public ReviewVO getFirstReview(int cno) {
		return cafeMapper.getFirstReview(cno);
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
