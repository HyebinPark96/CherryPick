// BoardDAO(interface), BoardDAOImpl(.java) 대신
// Mybatis3.0 이후로 나온 방식인 BoardMapper(.java, 인터페이스) BoardMapper(.xml) 이 더 최근에 나온 방식이며 사용하기도 더 편리하다.
// 또한, Mapper 인터페이스를 사용하지 않으면 1. SqlSession 등록해줘야 한다. 2. DAO인터페이스와 인터페이스를 구현한 DAO 클래스 각각 생성해줘야 함 3. 제공하는 메소드(insert, delete, selectOne)만 사용해야 한다.
// 그러므로 이번 프로젝트는 Mapper 인터페이스를 사용한 것임!

package com.pj.cherrypick.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pj.cherrypick.domain.BoardVO;
import com.pj.cherrypick.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	
	// 게시물 목록
	public List<BoardVO> list() throws Exception{
		return boardMapper.list();
	}
	
	// 게시물 작성
	public void write(BoardVO boardVO) throws Exception{
		boardMapper.write(boardVO);
	}
	
	// 게시물 조회
	public BoardVO view(int bno) throws Exception{
		return boardMapper.view(bno);
	}
	
	// 게시물 수정
	public void modify(BoardVO boardVO) throws Exception{
		boardMapper.modify(boardVO);
	}
	
	// 게시물 삭제	
	public void delete(int bno) throws Exception{
		boardMapper.delete(bno);
	}
	
	// 게시물 총 갯수
	public int count() throws Exception{
		return boardMapper.count();
	}
	
	// 게시물 목록  + 페이징
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception{
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost); // <S,I>
		data.put("postNum", postNum); // <S,I>
		
		return boardMapper.listPage(data.get("displayPost"), data.get("postNum")); // = listPage(int displayPost, int postNum)
	}
	
	
	
}
