package com.pj.cherrypick.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.BookmarkVO;
import com.pj.cherrypick.mapper.BookmarkMapper;

@Service
public class BookmarkService {


	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public List<BookmarkVO> checkBmkc(String username, int cno) {
		return bookmarkMapper.checkBmkc(username, cno);
	}
	
	public Boolean checkBmkli(Map<String, Object> map) {
		return bookmarkMapper.checkBmkli(map);
	}	
	
	public BookmarkVO checkCafeBmk(String username, int cno) {
		return bookmarkMapper.checkCafeBmk(username, cno);
	}

}