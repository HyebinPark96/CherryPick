package com.pj.cherrypick.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.mapper.AdminMapper;

@Service
public class AdminService {
	
	@Autowired
	AdminMapper adminMapper;
	
	public List<MemberVO> list() throws Exception{
		return adminMapper.list();
	};
	
	public void delete(String username) throws Exception{
		adminMapper.delete(username);
	};
	
	public int count() throws Exception{
		return adminMapper.count();
	};
	
	public List<MemberVO> listPage(int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭
		
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		return adminMapper.listPage(data.get("displayPost"), data.get("postNum")); // = listPage(int displayPost, int postNum)
	};
}
