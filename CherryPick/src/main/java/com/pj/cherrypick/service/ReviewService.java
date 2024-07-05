package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.ReviewVO;
import com.pj.cherrypick.mapper.ReviewMapper;

@Service
public class ReviewService {
	@Autowired
	private ReviewMapper reviewMapper;
	
	// 내가 작성한 리뷰 총 갯수
	public int count(String username) {
		return reviewMapper.count(username);
	}
	
	// 리뷰 작성
	@Transactional(rollbackFor = Exception.class)
	public void writeReviewProc(ReviewVO reviewVO) {
		
		reviewMapper.writeReviewProc(reviewVO);
	}
	
	// 수정을 위해 작성한 리뷰 가져오기
	public ReviewVO getOneReviewForUpdate(int rno) {
		return reviewMapper.getOneReviewForUpdate(rno);
	}
	
	// 리뷰 수정
	@Transactional(rollbackFor = Exception.class)
	public void updateReviewProc(ReviewVO reviewVO) {
		reviewMapper.updateReviewProc(reviewVO);
	}
	
	// 리뷰 삭제
	@Transactional(rollbackFor = Exception.class)
	public void deleteReviewProc(int rno) {
		reviewMapper.deleteReviewProc(rno);
	}
	
	
}
