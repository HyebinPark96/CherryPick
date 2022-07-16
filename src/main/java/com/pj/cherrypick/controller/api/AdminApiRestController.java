package com.pj.cherrypick.controller.api;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.service.BizMemberService;
import com.pj.cherrypick.service.MemberService;

@RestController
public class AdminApiRestController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BizMemberService bizMemberService;

	@PostMapping("/admin/memberManagement")
	public List<MemberVO> memberManagement(@RequestBody HashMap<String, String> sort) { // JSON 데이터 받으므로 @RequestBody 사용
		System.out.println("sort : " + sort.get("sort"));
		if(sort.get("sort").equals("member")) {
			if(memberService.getMList() != null || memberService.getMList().size() > 0) {
				List<MemberVO> memberList = memberService.getMList();
				return memberList;
			}
		}
		return null;
	}
	
	@PostMapping("/admin/bizMemberManagement")
	public List<BizMemberVO> bizMemberManagement(@RequestBody HashMap<String, String> sort) { // JSON 데이터 받으므로 @RequestBody 사용
		System.out.println("sort : " + sort.get("sort"));
		if(sort.get("sort").equals("biz")) {
			if(bizMemberService.getMList() != null || bizMemberService.getMList().size() > 0) {
				List<BizMemberVO> bizMemberList = bizMemberService.getMList();
				return bizMemberList;
			}
		}
		return null;
	}
	
}