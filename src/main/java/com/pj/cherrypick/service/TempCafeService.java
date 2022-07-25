package com.pj.cherrypick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.BoardVO;
import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.mapper.TempCafeMapper;
import com.pj.cherrypick.mapper.TempMenuMapper;

@Service
public class TempCafeService {
	
	@Autowired
	private TempCafeMapper cafeMapper;
	
	
	//검토 : @Transactional 어노테이션이 굳이 필요한가?
	
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
			cafeMapper.createMenu(menu);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return -1;
	}

	public List<CafeVO> listCafe(String bid) throws Exception {
		return cafeMapper.listCafe(bid);
	}
	
	public CafeVO getCafe(int cno) throws Exception {
		return cafeMapper.getCafe(cno);
	}

	public List<CafeMenuVO> getCafeMenu(int cno) throws Exception {
		return cafeMapper.getCafeMenu(cno);
	}
	
	@Transactional
	public int updateCafe(CafeVO cafe) throws Exception {
		try {
			cafeMapper.updateCafe(cafe);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return -1;
	}

	@Transactional
	public int updateMenu(CafeMenuVO menu) throws Exception {
		try {
			cafeMapper.updateMenu(menu);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return -1;
	}
	

	

}
