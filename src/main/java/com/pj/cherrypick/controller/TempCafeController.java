package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.service.TempCafeService;

@Controller
public class TempCafeController {

	@Autowired
	TempCafeService cafeService;
	// 스프링이 컴포넌트 스캔을 통해 Service.java의 @Service 어노테이션을 보면,
	// Bean에 등록을 해 줌 (=IoC 해줌)

	// BizMemberController로 통합 요망.
	@PostMapping("/bizMember/storeRegister")
	public String storeRegister(@SessionAttribute(name = "bizMember", required = false) BizMemberVO bizMember,
			Model model) {
		model.addAttribute("bizMember", bizMember);
		return "bizMember/storeRegister"; // model 들고 뷰로 이동
	}

	@PostMapping("/bizMember/storeList")
	public void listCafe(@SessionAttribute(name = "bizMember", required = false) BizMemberVO bizMember, CafeVO cafe,
			Model model) {
		model.addAttribute("bizMember", bizMember);

		List<CafeVO> cafeList = null;
		try {
			cafeList = cafeService.listCafe(bizMember.getBid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cafeList.size()>0) {
			System.out.println(cafeList.get(0).getCno());
		}else {
			System.out.println("no cafe selected");
		}
		
		
		model.addAttribute("cafe", cafeList);
	}
	/*
	@PostMapping("/bizMember/storeManagement")
	public void getCafe(@SessionAttribute(name = "bizMember", required = false) BizMemberVO bizMember, CafeVO cafe,
			Model model) {
		model.addAttribute("bizMember", bizMember);
		
		List<CafeMenuVO> list = null;
		
		try {
			list = cafeService.getCafe(cafe.getCno());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//model.addAttribute("cafe", cafe);
		
		try {
			list = cafeService.getCafeMenu(cafe.getCno());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
}
