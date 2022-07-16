package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.MemberVO;

@Repository("com.pj.cherrypick.mapper.AdminMapper") // XML 위치
@Mapper // 매퍼 사용하면 빈으로 등록되므로 Service단에서 Autowired로 사용 가능
public interface AdminMapper {
	
	/*1. 일반회원*/
	// 리스트
	public List<MemberVO> list() throws Exception;
	
	// 삭제
	public void delete(String username) throws Exception;
	
	// 총 갯수
	public int count() throws Exception;
	
	// 목록 + 페이징
	public List<MemberVO> listPage(int displayPost, int postNum) throws Exception;

	
	/*2. 사업자회원*/
	// 리스트
	public List<BizMemberVO> bList() throws Exception;
	
	// 삭제
	public void bDelete(String username) throws Exception;
	
	// 총 갯수
	public int bCount() throws Exception;
	
	// 목록 + 페이징
	public List<BizMemberVO> bListPage(int displayPost, int postNum) throws Exception;
	
}