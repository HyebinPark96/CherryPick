package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.pj.cherrypick.domain.BizMemberVO;
import com.pj.cherrypick.domain.CafeMenuVO;
import com.pj.cherrypick.domain.CafeVO;
import com.pj.cherrypick.domain.ReviewVO;
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
		
		model.addAttribute("cafe", cafeList);
	}
	

	@GetMapping("/bizMember/storeManagement/{cno}")
	public String storeManagement(@SessionAttribute(name = "bizMember", required = false) @PathVariable int cno, Model model) {
		
		CafeVO cafe = null;
		List<CafeMenuVO> menulist = null;
		
		try {
			cafe = cafeService.getCafe(cno);
			menulist = cafeService.getCafeMenu(cno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("cno", cno);
		model.addAttribute("cafe", cafe);
		model.addAttribute("menu", menulist);
		return "bizMember/storeManagement";
	}


}
