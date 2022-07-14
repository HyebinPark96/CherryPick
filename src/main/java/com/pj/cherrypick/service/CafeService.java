package com.pj.cherrypick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.mapper.CafeMapper;

@Service
public class CafeService {
	
	@Autowired
	private CafeMapper cafeMapper;
	
	public List<CafeVO> getCafeAllByScore() {
		return cafeMapper.getCafeAllByScore();
		
	}

	public List<CafeVO> getCafeAll() {
		return cafeMapper.getCafeAll();
	}
	
	public ReviewVO getFirstReview(int cno) {
		return cafeMapper.getFirstReview(cno);
	}
	
	public ListVO getEachList(int lino) {
		return cafeMapper.getEachList(lino);
	}
	
	public List<CafeVO> getCafeList(int cno) {
		return cafeMapper.getCafeList(cno);
	}	
	
	public CafeVO getCafeInfo(int cno) {
		return cafeMapper.getCafeInfo(cno);
	}
	
	public List<CafeMenuVO> getCafeMenu(int cno) {
		return cafeMapper.getCafeMenu(cno);
	}
	
	public List<ReviewVO> getReview(int cno) {
		return cafeMapper.getReview(cno);
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
