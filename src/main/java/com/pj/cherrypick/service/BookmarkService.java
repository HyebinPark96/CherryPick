package com.pj.cherrypick.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.mapper.BookmarkMapper;

@Service
public class BookmarkService {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public Boolean checkBmkc(Map<String, Object> map) {
		return bookmarkMapper.checkBmkc(map);
	}
	
	public Boolean checkBmkli(Map<String, Object> map) {
		return bookmarkMapper.checkBmkli(map);
	}	

}
