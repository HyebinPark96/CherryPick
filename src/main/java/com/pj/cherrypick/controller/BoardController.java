package com.pj.cherrypick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.cherrypick.domain.BoardVO;
import com.pj.cherrypick.domain.Page;
import com.pj.cherrypick.service.BoardService;

@Controller
@RequestMapping("/board/*") // 자동으로 /board/ 아래 매핑 찾아가짐
public class BoardController {
	
	@Autowired
	BoardService boardService; // 스프링이 컴포넌트 스캔을 통해 BoardService.java의 @Service 어노테이션을 보면 Bean에 등록을 해 줌 (=IoC 해줌)

	// 게시물 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) {
		List<BoardVO> list = null;
		try {
			list = boardService.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("list", list);
	}
	
	// 게시물 작성 페이지로 이동
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception{
		
	}
		
	// 게시물 작성 proc
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO boardVO) throws Exception{
		boardService.write(boardVO);
		return "redirect:/board/list"; // redirect : 모든 작업을 마치고 /board/list, 즉 게시물 목록 화면으로 이동하겠다는 의미
	}
	
	// 게시물 조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception{ // @RequestParam : 주소에 있는 특정한 값을 가져올 수 있음 => bno 가져와서 int bno에 할당
		BoardVO boardVO = boardService.view(bno);
		
		model.addAttribute("view", boardVO); // model 가지고 뷰로 이동
	}
	
	// 게시물 수정 페이지로 이동
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void getModify(@RequestParam("bno") int bno, Model model) throws Exception{ 
		BoardVO boardVO = boardService.view(bno);
		
		model.addAttribute("view", boardVO); // model 가지고 뷰로 이동
	}
	
	// 게시물 수정 Proc
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postModify(BoardVO boardVO) throws Exception{
		boardService.modify(boardVO); // 수정
		
		return "redirect:/board/view?bno=" + boardVO.getBno(); // 해당 게시물 조회 페이지로 이동
	}
	
	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("bno") int bno) throws Exception{
		boardService.delete(bno);
		
		return "redirect:/board/list";
	}
	
	// 게시물 목록 + 페이징 추가
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void getListPage(Model model, @RequestParam("num") int num) throws Exception{ // num : 페이지 번호
		
		/*domain 폴더 아래 Page.java로 옮김*/
//		// 게시물 총 갯수
//		int count = boardService.count();
//		
//		// 한 페이지에 출력할 게시물 갯수
//		int postNum = 10;
//		
//		// 하단 페이징 번호 ([게시물 총 갯수 %(자바의 나머지를 출력하는 나누기가 아닌 실제 몫과 나머지를 나타내는 나누기) 한 페이지에 출력할 갯수] 의 올림)
//		int pageNum = (int)Math.ceil((double)count/postNum); // Math.ceil() : 올림함수 (double형을 올림하면 올림된 double형 반환 ex. 3.0) -> int로 강제 casting
//		
//		// 출력할 게시물
//		int displayPost = (num - 1) * postNum; // limit(시작할 인덱스 번호, 종료할 인덱스 번호)의 앞 매개변수에 들어갈 변수
//		
//		// 한 번에 표시할 페이징 번호의 갯수
//		int pageNum_cnt = 10;
//		
//		// 표시되는 페이지 번호 중 마지막 번호
//		int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt); // 현재 페이지의 마지막 번호를 알 수 있다면 현재 페이지의 시작 번호도 알 수 있다.
//		
////		System.out.println("1 페이지일 때 : " + (1 / 10)); // 1/10 = 0 => 올림적용해도 0이므로 double형 변환해야 함
////		
////		System.out.println("10 페이지일 때 : " + ((double)10 / (double)10)); // 10.0 / 10.0 = 1.0
////		System.out.println("10 페이지일 때 : " + (int)(Math.ceil((double)10 / (double)10))); // 1.0 올림 => 1
////		
////		System.out.println("1 페이지일 때 : " + ((double)1 / (double)10)); // 1.0 / 10.0 = 0.1
////		System.out.println("1 페이지일 때 : " + (int)(Math.ceil((double)1 / (double)10))); // 0.1 올림 => 1
//		// 결론은 1~10, 11~20, ... 모두 올림하면 1, 2, 3, ... (현재 페이징 구역) 이 나오고,
//		// 거기에 * 10(10개씩 페이징할 경우)을 하면 현재 페이징 구역의 마지막 페이지를 구할 수 있다.
//		
//		// 표시되는 페이지 번호 중 첫번째 번호
//		int startPageNum = endPageNum - (pageNum_cnt - 1); // 총 10페이지씩 보여준다면 마지막 페이지 - 9(마지막 페이지에서 앞으로 9칸 이동하면 첫번째 페이지)가 공식이 된다.
//		
//		// 마지막 번호 재계산
//		int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
//		
//		if(endPageNum > endPageNum_tmp) {
//			endPageNum = endPageNum_tmp; // ex. 112개 레코드 10개씩 출력시 올림(112.0/10.0) => 12 페이지까지 필요하니까 13페이지~20(기존 방법으로 구한 마지막 페이지)은 필요없음
//		}
//		
//		boolean prev = startPageNum == 1 ? false : true;
//		boolean next = endPageNum * pageNum_cnt >= count ? false : true;
//
//		List<BoardVO> list = null;
//		list = boardService.listPage(displayPost, postNum); // (0, 10), (10, 10), (20, 10), ... 
//		model.addAttribute("list", list);
//		model.addAttribute("pageNum", pageNum);
//		
//		// 시작 및 끝 번호
//		model.addAttribute("startPageNum", startPageNum);
//		model.addAttribute("endPageNum", endPageNum);
//		
//		// 이전 및 다음
//		model.addAttribute("prev", prev);
//		model.addAttribute("next", next);
//		
//		// 현재 페이지
//		model.addAttribute("select", num);
		
		Page page = new Page();
		
		page.setNum(num);
		page.setCount(boardService.count());  

		List<BoardVO> list = null; 
		list = boardService.listPage(page.getDisplayPost(), page.getPostNum());

		model.addAttribute("list", list); 
		model.addAttribute("page", page);
		System.out.println("ss" + page.getStartPageNum());
		
		/*아래 코드는 page 관련 코드이므로 위 코드 한 줄로 요약 가능 => 뷰에서 page.변수명으로 접근 가능*/
		
		/*
		model.addAttribute("pageNum", page.getPageNum());

		model.addAttribute("startPageNum", page.getStartPageNum());
		model.addAttribute("endPageNum", page.getEndPageNum());
		 
		 model.addAttribute("prev", page.getPrev());
		model.addAttribute("next", page.getNext());  
		*/

		model.addAttribute("select", num);
	}
	
}
