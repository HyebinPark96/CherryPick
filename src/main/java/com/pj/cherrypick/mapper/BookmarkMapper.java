package com.pj.cherrypick.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.BookmarkVO;

@Repository("com.pj.cherrypick.mapper.BookmarkMapper")
@Mapper
public interface BookmarkMapper {

	// 특정유저(username) 카페북마크 여부 가져오기
	List<BookmarkVO> checkBmkc(String username, int cno) throws Exception;
	
	// 특정유저(username) 리스트북마크 여부 가져오기
	Boolean checkBmkli(Map<String, Object> map) throws Exception;
	
	// 내(username)가 이 카페(cno)를 북마크했는지 체크
	BookmarkVO checkCafeBmk(String username, int cno) throws Exception;
	
	// 북마크 카페 추가
	public void addBmkc(BookmarkVO bookmarkVO) throws Exception;
	
	// 북마크 카페 삭제
	public void delBmkc(String username, int cno) throws Exception;
}
