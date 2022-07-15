package com.pj.cherrypick.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("com.pj.cherrypick.mapper.BookmarkMapper")
@Mapper
public interface BookmarkMapper {

	// 특정유저(username) 카페북마크 여부 가져오기
	Boolean checkBmkc(Map<String, Object> map);
	
	// 특정유저(username) 리스트북마크 여부 가져오기
	Boolean checkBmkli(Map<String, Object> map);

}
