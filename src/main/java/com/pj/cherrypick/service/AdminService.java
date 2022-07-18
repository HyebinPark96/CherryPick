package com.pj.cherrypick.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.mapper.AdminMapper;

@Service
public class AdminService {
	
	@Autowired
	AdminMapper adminMapper;
	
	public List<MemberVO> list() throws Exception{
		return adminMapper.list();
	};
	
	@Transactional(rollbackFor = Exception.class)
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
	
	public List<BizMemberVO> bAuthList() throws Exception{
		return adminMapper.bAuthList();
	};
	
	public List<BizMemberVO> bUnauthList() throws Exception{
		return adminMapper.bUnauthList();
	};
	
	@Transactional(rollbackFor = Exception.class)
	public void bDelete(String bid) throws Exception{
		adminMapper.bDelete(bid);
	};
	
	public int bAuthCount(int bstat) throws Exception{
		return adminMapper.bAuthCount(bstat);
	};
	
	public int bUnauthCount(int bstat) throws Exception{
		return adminMapper.bUnauthCount(bstat);
	};
	
	public List<BizMemberVO> bAuthListPage(int bstat, int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭

		data.put("bstat", bstat);
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		return adminMapper.bAuthListPage(data.get("bstat"), data.get("displayPost"), data.get("postNum"));
	};
	
	public List<BizMemberVO> bUnauthListPage(int bstat, int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭
		
		data.put("bstat", bstat);
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		return adminMapper.bUnauthListPage(data.get("bstat"), data.get("displayPost"), data.get("postNum"));
	};
	
	
}
