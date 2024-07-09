package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pj.cherrypick.domain.ListVO;
import com.pj.cherrypick.service.CherriesService;

@Controller
public class CherriesController {

	@Autowired
	private CherriesService cherriesService;
	
	//Cherries list
	//최신순
	@RequestMapping("cafe/cherries")
	public String getNewCherries (Model model) throws Exception {
		
		List<ListVO> latest = cherriesService.getNewCherries();
		model.addAttribute("latest", latest);
		// System.out.println("-----------------------------------");
		// System.out.println("[new model]:"+model);
		// System.out.println("[new]:"+latest);
		
		return "cafe/cherries";
	}	
	

}
