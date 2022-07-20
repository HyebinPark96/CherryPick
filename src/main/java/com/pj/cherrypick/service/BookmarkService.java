package com.pj.cherrypick.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.BookmarkVO;
import com.pj.cherrypick.mapper.BookmarkMapper;

@Service
public class BookmarkService {

	@Autowired
	private BookmarkMapper bookmarkMapper;

	public int checkCafeBmk(String username, int cno) throws Exception {

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("username", username);
		m.put("cno", cno);

		BookmarkVO vo = bookmarkMapper.checkCafeBmk(m);

		if (vo.getChk() == 0 || vo.getChk() == null) {
			return 0;
		} else {
			return 1;
		}
	}

	@Transactional
	public int addBmkc(String username, int cno) throws Exception {

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("username", username);
		m.put("cno", cno);
		// System.out.println(m);
		BookmarkVO vo = bookmarkMapper.checkCafeBmk(m);

		if (vo.getChk() == 0 || vo.getChk() == null) {
			bookmarkMapper.addBmkc(username, cno);
			return 1;
		} else {
			bookmarkMapper.delBmkc(username, cno);
			return 0;
		}
	}

	public BookmarkVO checkCafeBmkAll(BookmarkVO vo) throws Exception {
		
		//System.out.println("service:"+vo);
		BookmarkVO check = bookmarkMapper.checkCafeBmkAll(vo);
		check.setUsername(vo.getUsername());
		return check;
	}
	
	
	@Transactional
	public int addBmkcAll(String username, int cno) throws Exception {

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("username", username);
		m.put("cno", cno);
		// System.out.println(m);
		BookmarkVO vo = bookmarkMapper.checkCafeBmk(m);

		if (vo.getChk() == 0 || vo.getChk() == null) {
			bookmarkMapper.addBmkc(username, cno);
			return 1;
		} else {
			bookmarkMapper.delBmkc(username, cno);
			return 0;
		}
	}	

	public int checkListBmk(String username, int lino) throws Exception {

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("username", username);
		m.put("lino", lino);

		BookmarkVO vo = bookmarkMapper.checkListBmk(m);

		if (vo.getChk() == 0 || vo.getChk() == null) {
			return 0;
		} else {
			return 1;
		}
	}

	@Transactional
	public int addBmkli(String username, int lino) throws Exception {

		Map<String, Object> m = new HashMap<String, Object>();
		m.put("username", username);
		m.put("lino", lino);
		// System.out.println(m);
		BookmarkVO vo = bookmarkMapper.checkListBmk(m);

		if (vo.getChk() == 0 || vo.getChk() == null) {
			bookmarkMapper.addBmkli(username, lino);
			return 1;
		} else {
			bookmarkMapper.delBmkli(username, lino);
			return 0;
		}
	}
	
	
}
	

