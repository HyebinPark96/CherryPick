package com.pj.cherrypick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.mapper.TempCafeMapper;
import com.pj.cherrypick.mapper.TempMenuMapper;

@Service
public class TempCafeService {
	
	@Autowired
	private TempCafeMapper cafeMapper;
	@Autowired
	private TempMenuMapper menuMapper;
	
	@Transactional
	public int createCafe(CafeVO cafe) {
		try {
			cafeMapper.createCafe(cafe);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return -1;
		
	}
	
	@Transactional
	public int getCafeNo() {
			int cno = cafeMapper.getCafeNo();
			
		return cno;
		
	}
	
	@Transactional
	public int createMenu(CafeMenuVO menu) {
		try {
			menuMapper.createMenu(menu);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return -1;
		
	}
	

}
