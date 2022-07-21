package com.pj.cherrypick.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.domain.ReviewVO;
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
	
	public int searchCount(String searchType, String keyword) throws Exception{
		return adminMapper.searchCount(searchType, keyword);
	};
	
	// 목록 + 페이징
	public List<MemberVO> listPage(int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭
		
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		return adminMapper.listPage(data.get("displayPost"), data.get("postNum")); // = listPage(int displayPost, int postNum)
	};
	
	// 목록 + 페이징 + 검색
	public List<MemberVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception{
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost); 
		data.put("postNum", postNum);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return adminMapper.listPageSearch((int)data.get("displayPost"), (int)data.get("postNum"), 
				data.get("searchType").toString(), data.get("keyword").toString());
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
	
	public int bAuthSearchCount(int bstat, String searchType, String keyword) throws Exception{
		return adminMapper.bAuthSearchCount(bstat);
	};
	
	public int bUnauthCount(int bstat) throws Exception{
		return adminMapper.bUnauthCount(bstat);
	};
	
	public int bUnauthSearchCount(int bstat, String searchType, String keyword) throws Exception{
		return adminMapper.bUnauthSearchCount(bstat);
	};
	
	public List<BizMemberVO> bAuthListPage(int bstat, int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭

		data.put("bstat", bstat);
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		return adminMapper.bAuthListPage(data.get("bstat"), data.get("displayPost"), data.get("postNum"));
	};
	
	public List<BizMemberVO> bAuthListPageSearch(int bstat, int displayPost, int postNum, String searchType, String keyword) throws Exception{
		HashMap<String, Object> data = new HashMap<String, Object>(); 

		data.put("bstat", bstat);
		data.put("displayPost", displayPost);
		data.put("postNum", postNum); 
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return adminMapper.bAuthListPageSearch((int)data.get("bstat"), (int)data.get("displayPost"), (int)data.get("postNum"),
				data.get("searchType").toString(), data.get("keyword").toString());
	};
	
	public List<BizMemberVO> bUnauthListPage(int bstat, int displayPost, int postNum, String searchType, String keyword) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭
		
		data.put("bstat", bstat);
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		return adminMapper.bUnauthListPage(data.get("bstat"), data.get("displayPost"), data.get("postNum"));
	};
	
	public List<BizMemberVO> bUnauthListPageSearch(int bstat, int displayPost, int postNum, String searchType, String keyword) throws Exception{
		HashMap<String, Object> data = new HashMap<String, Object>(); 

		data.put("bstat", bstat);
		data.put("displayPost", displayPost);
		data.put("postNum", postNum); 
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return adminMapper.bUnauthListPageSearch((int)data.get("bstat"), (int)data.get("displayPost"), (int)data.get("postNum"),
				data.get("searchType").toString(), data.get("keyword").toString());
	};
	
	public List<CafeVO> cafeList() throws Exception{
		return adminMapper.cafeList();
	}
	
	public List<CafeVO> cafeListPage(int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭
		
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		if(adminMapper.cafeListPage(data.get("displayPost"), data.get("postNum")).size()>0 || adminMapper.cafeListPage(data.get("displayPost"), data.get("postNum"))!=null) {
			return adminMapper.cafeListPage(data.get("displayPost"), data.get("postNum"));
		}
		return null;
	}
	
	public int cCount() throws Exception{
		int cCount = 0;
		if(adminMapper.cCount()!=0) {
			cCount = adminMapper.cCount();
		}
		return cCount;
	}
	
	public List<ReviewVO> getReviewList(int cno, int displayPost, int postNum) {
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭
		
		data.put("cno", cno);
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		
		if(adminMapper.getReviewList(data.get("cno"), data.get("displayPost"), data.get("postNum")).size()>0 || adminMapper.getReviewList(data.get("cno"), data.get("displayPost"), data.get("postNum"))!=null) {
			return adminMapper.getReviewList(data.get("cno"), data.get("displayPost"), data.get("postNum"));
		}
		return null;
	}
	
	public int rCount(int cno) throws Exception{
		int rCount = 0;
		if(adminMapper.rCount(cno)!=0) {
			rCount = adminMapper.rCount(cno);
		}
		return rCount;
	}
	
	public CafeVO getCafeInfo(int cno) throws Exception{
		CafeVO cafe = null;
		if(adminMapper.getCafeInfo(cno)!=null) {
			cafe = adminMapper.getCafeInfo(cno);
			return cafe;
		}
		return null;
	}
	
	public ReviewVO getOneReview(int rno) throws Exception{
		ReviewVO review = null;
		if(adminMapper.getOneReview(rno)!=null) {
			review = adminMapper.getOneReview(rno);
			return review;
		}
		return null;
	}
	
}
