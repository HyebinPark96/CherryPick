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
	
	public List<MemberVO> listPageSearchOrderByRegDate(String searchType, String keyword) throws Exception {
		List<MemberVO> mListOrderByRegDate = null;
		mListOrderByRegDate = adminMapper.listPageSearchOrderByRegDate(searchType, keyword);
		return mListOrderByRegDate;
	}
	
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
	
	public void withdrawalForMem(String username[]) throws Exception{
		adminMapper.withdrawalForMem(username);
	}
	
	// 목록 + 페이징
	public List<MemberVO> listPage(int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭
		
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		return adminMapper.listPage(data.get("displayPost"), data.get("postNum")); // = listPage(int displayPost, int postNum)
	};
	
	// 목록 + 페이징 + 검색 : 이름순 정렬
	public List<MemberVO> listPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception{
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost); 
		data.put("postNum", postNum);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return adminMapper.listPageSearch((int)data.get("displayPost"), (int)data.get("postNum"), 
				data.get("searchType").toString(), data.get("keyword").toString());
	};
	
	// 목록 + 페이징 + 검색 : 가입일자순 정렬
	public List<MemberVO> listPageSearchOrderByRegDate(int displayPost, int postNum, String searchType, String keyword) throws Exception{
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost); 
		data.put("postNum", postNum);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return adminMapper.listPageSearchOrderByRegDate((int)data.get("displayPost"), (int)data.get("postNum"), 
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
		return adminMapper.bAuthSearchCount(bstat, searchType, keyword);
	};
	
	public int bUnauthCount(int bstat) throws Exception{
		return adminMapper.bUnauthCount(bstat);
	};
	
	public int bUnauthSearchCount(int bstat, String searchType, String keyword) throws Exception{
		return adminMapper.bUnauthSearchCount(bstat, searchType, keyword);
	};
	
	public void withdrawalForAuthBiz(String bid[]) throws Exception{
		adminMapper.withdrawalForAuthBiz(bid);
	}
	
	public void cancleApproval(String bid) throws Exception{
		adminMapper.cancleApproval(bid);
	}
	
	public void approval(String bid) throws Exception{
		adminMapper.approval(bid);
	}
	
	public void checkApproval(String bid[]) throws Exception{
		adminMapper.checkApproval(bid);
	}
	
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
	
	public List<BizMemberVO> bAuthListPageSearchOrderByRegDate(int bstat, int displayPost, int postNum, String searchType, String keyword) throws Exception{
		HashMap<String, Object> data = new HashMap<String, Object>(); 

		data.put("bstat", bstat);
		data.put("displayPost", displayPost);
		data.put("postNum", postNum); 
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return adminMapper.bAuthListPageSearchOrderByRegDate((int)data.get("bstat"), (int)data.get("displayPost"), (int)data.get("postNum"),
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
	
	public List<BizMemberVO> bUnauthListPageSearchOrderByRegDate(int bstat, int displayPost, int postNum, String searchType, String keyword) throws Exception{
		HashMap<String, Object> data = new HashMap<String, Object>(); 

		data.put("bstat", bstat);
		data.put("displayPost", displayPost);
		data.put("postNum", postNum); 
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return adminMapper.bUnauthListPageSearchOrderByRegDate((int)data.get("bstat"), (int)data.get("displayPost"), (int)data.get("postNum"),
				data.get("searchType").toString(), data.get("keyword").toString());
	};
	
	public List<CafeVO> cafeList() throws Exception{
		return adminMapper.cafeList();
	}
	
	// 사업장 리스트 목록 + 페이징 : 레코드를 10개씩 출력
	public List<CafeVO> cafeListPage(int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭
		
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		
		
		return adminMapper.cafeListPage(data.get("displayPost"), data.get("postNum"));
	}
	
	// 사업장 리스트 목록 + 페이징 + 검색 : 레코드를 10개씩 출력
	public List<CafeVO> cafeListPageSearch(int displayPost, int postNum, String searchType, String keyword) throws Exception{
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("displayPost", displayPost); 
		data.put("postNum", postNum);
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return adminMapper.cafeListPageSearch((int)data.get("displayPost"), (int)data.get("postNum"), 
				data.get("searchType").toString(), data.get("keyword").toString());
	}
	
	public int cCount() throws Exception{
		int cCount = 0;
		if(adminMapper.cCount()!=0) {
			cCount = adminMapper.cCount();
		}
		return cCount;
	}
	
	public int cSearchCount(String searchType, String keyword) throws Exception{
		int cSearchCount = 0;
		if(adminMapper.cSearchCount(searchType, keyword)!=0) {
			cSearchCount = adminMapper.cSearchCount(searchType, keyword);
		}
		return cSearchCount;
	}
	
	public List<ReviewVO> getReviewList(int cno, int displayPost, int postNum) throws Exception {
		HashMap<String, Integer> data = new HashMap<String, Integer>(); // Key 와 Value의 제네릭
		
		data.put("cno", cno);
		data.put("displayPost", displayPost); // <K,V> = <S,I>
		data.put("postNum", postNum); // <K,V> = <S,I>
		

		return adminMapper.getReviewList(data.get("cno"), data.get("displayPost"), data.get("postNum"));
	}
	
	public List<ReviewVO> getReviewListSearch(int cno, int displayPost, int postNum, String searchType, String keyword) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		data.put("cno", cno);
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		data.put("searchType", searchType);
		data.put("keyword", keyword);
		
		return adminMapper.getReviewListSearch((int)data.get("cno"), (int)data.get("displayPost"), 
					(int)data.get("postNum"), data.get("searchType").toString(), data.get("keyword").toString());
	}
	
	public int rCount(int cno) throws Exception{
		int rCount = 0;
		if(adminMapper.rCount(cno)!=0) {
			rCount = adminMapper.rCount(cno);
		}
		return rCount;
	}
	
	public int rSearchCount(int cno, String searchType, String keyword) throws Exception{
		int rCount = 0;
		if(adminMapper.rSearchCount(cno, searchType, keyword)!=0) {
			rCount = adminMapper.rSearchCount(cno, searchType, keyword);
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
	
	public void adminReviewDelete(int rno[]) throws Exception{
		adminMapper.adminReviewDelete(rno);
	}
	
}
