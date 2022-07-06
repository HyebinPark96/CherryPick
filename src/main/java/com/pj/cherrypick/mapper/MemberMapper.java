package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pj.cherrypick.domain.MemberVO;

@Repository("com.pj.cherrypick.mapper.MemberMapper") // XML 위치
@Mapper // 매퍼 사용하면 빈으로 등록되므로 Service단에서 Autowired로 사용 가능
public interface MemberMapper {
	
	List<MemberVO> listmap();
	
	void signUp(MemberVO member) throws Exception;
	
}
