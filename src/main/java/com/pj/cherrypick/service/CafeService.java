package com.pj.cherrypick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.FilterVO;
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
	
	public List<CafeVO> getCafeAll2(FilterVO filter) {
		return cafeMapper.getCafeAll2(filter);
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
	
	public List<ReviewVO> getReview(int cno, int displayPost, int postNum) {
		return cafeMapper.getReview(cno, displayPost, postNum);
	}
	
	public List<CafeVO> getMyCafeBmk(String username) {
		return cafeMapper.getMyCafeBmk(username);
	}
	
	public List<ListVO> getMyListBmk(String username) {
		return cafeMapper.getMyListBmk(username);
	}
	
	public List<CafeVO> getCafeAllByScore(FilterVO filter) {
		System.out.println("[service] getCafeAllByScore");
		return cafeMapper.getCafeAllByScore(filter);
	}
	
	public List<CafeVO> getCafeAllByReview(FilterVO filter) {
		return cafeMapper.getCafeAllByReview(filter);
	}

	public List<CafeVO> getCafeAllByBmk(FilterVO filter) {
		return cafeMapper.getCafeAllByBmk(filter);
	}
	
	public int cntReview(int cno) {
		return cafeMapper.cntReview(cno);
	}
	
}
