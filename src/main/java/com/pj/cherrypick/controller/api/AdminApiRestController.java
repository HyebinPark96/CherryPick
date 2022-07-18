package com.pj.cherrypick.controller.api;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.service.AdminService;
import com.pj.cherrypick.service.BizMemberService;
import com.pj.cherrypick.service.MemberService;

@RestController
public class AdminApiRestController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BizMemberService bizMemberService;
	
	@Autowired
	AdminService adminService;

	@PostMapping("/admin/memberManagement")
	public List<MemberVO> memberManagement(@RequestBody HashMap<String, String> sort) { // JSON 데이터 받으므로 @RequestBody 사용
		
		if(sort.get("sort").equals("member")) {
			if(memberService.getMList() != null || memberService.getMList().size() > 0) {
				List<MemberVO> memberList = memberService.getMList();
				return memberList;
			}
		}
		return null;
	}
	
	@PostMapping("/admin/authBizMemberManagement")
	public List<BizMemberVO> bizMemberManagement(@RequestBody HashMap<String, String> sort) throws Exception {

		if(sort.get("sort").equals("authBizMember")) {
			if(adminService.bAuthList() != null || adminService.bAuthList().size() > 0) {
				List<BizMemberVO> authBizMemberList = adminService.bAuthList();
				return authBizMemberList;
			}
		}
		return null;
	}
	
	@PostMapping("/admin/unauthBizMemberManagement")
	public List<BizMemberVO> unauthBizMemberManagement(@RequestBody HashMap<String, String> sort) throws Exception {

		if(sort.get("sort").equals("unauthBizMember")) {
			if(adminService.bUnauthList() != null || adminService.bUnauthList().size() > 0) {
				List<BizMemberVO> unauthBizMemberList = adminService.bUnauthList();
				return unauthBizMemberList;
			}
		}
		return null;
	}
	
}