package com.simple.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller
@RequestMapping("/service")
public class BoardController {
	
	@Autowired
	private BoardService boardService; //서비스 입력값을 적는다

	//등록화면 이동
	@RequestMapping("/boardRegister")
	public void boardRegist() {
		
	}
	
	//등록화면 내용가져오기
	@RequestMapping("/boardForm")
	public String boardForm(BoardVO vo) {
		
		boardService.boardRegist(vo);
		
		return "service/boardResult";
	}
	
	//결과화면 이동
	@RequestMapping("/boardResult")
	public void boardResult() {
			
	}
		
	//목록화면으로 이동
	@RequestMapping("/boardList")
	public String boardList(Model model) {
			
		model.addAttribute("list", boardService.getList());
		
		return "service/boardList";
		
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num,
											RedirectAttributes RA) {
		
		boardService.boardDelete(num);
		RA.addFlashAttribute("num", num);
		
		
		return "redirect:/service/boardList";
	}
	
	
	
	
	
	
	
}
