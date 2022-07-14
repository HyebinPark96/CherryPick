package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.mapper.CafeMapper;

@Service
public class TempCafeService {
	
	@Autowired
	private CafeMapper cafeMapper;
	

	public int createCafe(CafeVO cafe) {
		return cafeMapper.createCafe(cafe);
	}
	

}
