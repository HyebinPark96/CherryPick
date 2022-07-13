package com.pj.cherrypick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.mapper.HomeMapper;

@Service
public class HomeService {
	
	@Autowired
	private HomeMapper homeMapper;

	public List<ListVO> getTodayList() {
		return homeMapper.getTodayList();
	}
}
