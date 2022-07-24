package com.pj.cherrypick.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.MemberVO;
import com.pj.cherrypick.response.ResponseDto;
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
	
	@PostMapping("/admin/cafeManagement")
	public List<CafeVO> cafeManageMent(@RequestBody HashMap<String, String> sort) throws Exception {
		
		if(sort.get("sort")!=null) {
			if(sort.get("sort").equals("cafe")) {
				if(adminService.cafeList()!= null || adminService.cafeList().size() > 0) {
					List<CafeVO> cafeList = adminService.cafeList();
					return cafeList;
				}
			}
		}

		return null;
	}
	
	@PostMapping("/admin/withdrawalForMem")
	public ResponseDto<Integer> withdrawalForMem(@RequestBody String checkedMemChkArr[]) throws Exception {
		
		// 테스트
		/*
		for (int i = 0; i < checkedMemChkArr.length; i++) {
			System.out.println(checkedMemChkArr[i]);
		}
		*/
		
		adminService.withdrawalForMem(checkedMemChkArr);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		
	}
	
	@PostMapping("/admin/withdrawalForAuthBiz")
	public ResponseDto<Integer> withdrawalForAuthBiz(@RequestBody String checkedAuthBizChkArr[]) throws Exception {
		
		// 테스트
		/*
		for (int i = 0; i < checkedAuthBizChkArr.length; i++) {
			System.out.println("삭제 : " + checkedAuthBizChkArr[i]);
		}
		*/
		
		adminService.withdrawalForAuthBiz(checkedAuthBizChkArr);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		
	}
	
	// 승인취소
	@PostMapping("/admin/cancleApproval")
	public ResponseDto<Integer> cancleApproval(@RequestBody Map<String, String> map) throws Exception {
		adminService.cancleApproval(map.get("bid"));
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	// 승인
	@PostMapping("/admin/approval")
	public ResponseDto<Integer> approval(@RequestBody Map<String, String> map) throws Exception {
		adminService.approval(map.get("bid"));
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	// 선택 승인
	@PostMapping("/admin/checkApproval")
	public ResponseDto<Integer> checkApproval(@RequestBody String checkedApprovalArr[]) throws Exception {
		// 테스트
		/*
		for (int i = 0; i < checkedApprovalArr.length; i++) {
			System.out.println("선택 승인 : " + checkedApprovalArr[i]);
		}
		*/
		
		adminService.checkApproval(checkedApprovalArr);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	// 리뷰 삭제
	@PostMapping("/admin/adminReviewDelete")
	public ResponseDto<Integer> adminReviewDelete(@RequestBody int checkedAdminReviewDeleteArr[]) throws Exception {
		adminService.adminReviewDelete(checkedAdminReviewDeleteArr);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
}