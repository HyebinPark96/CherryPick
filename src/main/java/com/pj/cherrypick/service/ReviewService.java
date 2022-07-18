package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.mapper.ReviewMapper;

@Service
public class ReviewService {
	@Autowired
	private ReviewMapper reviewMapper;
	
	// 내가 작성한 리뷰 총 갯수
	public int count(String username) {
		return reviewMapper.count(username);
	}
	
}
