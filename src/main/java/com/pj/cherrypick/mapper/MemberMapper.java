package com.pj.cherrypick.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pj.cherrypick.domain.MemberVO;

@Mapper // 매퍼 사용하면 빈으로 등록되므로 Service단에서 Autowired로 사용 가능
public interface MemberMapper {
	public List<MemberVO> listmap();
}
