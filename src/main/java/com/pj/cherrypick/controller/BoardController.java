package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pj.cherrypick.domain.BoardVO;
import com.pj.cherrypick.service.BoardService;

@Controller
@RequestMapping("/board/*") // 자동으로 /board/ 아래 매핑 찾아가짐
public class BoardController {
	
	@Autowired
	BoardService boardService; // 스프링이 컴포넌트 스캔을 통해 BoardService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌 (=IoC 해줌)

		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public void getList(Model model) {
			List<BoardVO> list = null;
			try {
				list = boardService.list();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addAttribute("list", list);
		}
		
}
