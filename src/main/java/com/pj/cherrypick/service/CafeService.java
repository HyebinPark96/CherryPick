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
	
	public List<CafeVO> getCafeAll() {
		return cafeMapper.getCafeAll();
	}
	
	public List<CafeVO> getCafeAll2() {
		return cafeMapper.getCafeAll2();
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
	
	public List<CafeVO> getMyCafeBmk(String username) {
		return cafeMapper.getMyCafeBmk(username);
	}
	
	public List<ListVO> getMyListBmk(String username) {
		return cafeMapper.getMyListBmk(username);
	}
	
	public List<CafeVO> getCafeAllByScore() {
		return cafeMapper.getCafeAllByScore();
	}
	
	public List<CafeVO> getCafeAllByReview() {
		return cafeMapper.getCafeAllByReview();
	}

	public List<CafeVO> getCafeAllByBmk() {
		return cafeMapper.getCafeAllByBmk();
	}
	
}
