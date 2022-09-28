package com.pj.cherrypick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.FilterVO;
import com.pj.cherrypick.mapper.SearchMapper;

@Service
public class SearchService {
	@Autowired
	private SearchMapper searchMapper;
	
	public List<CafeVO> getCafeByName(String keyword, FilterVO filter) {
		return searchMapper.getCafeByName(keyword, filter);
	}
	
	public List<CafeVO> getCafeByTag(String keyword, FilterVO filter) {
		return searchMapper.getCafeByTag(keyword, filter);
	}
	
	/*
	public List<ListVO> getListByName(FilterVO filter) {
		return searchMapper.getListByName(filter);
	}
	*/
	
	
}
