package com.simple.basic;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {

	//1st
	//private ScoreServiceImpl service = new ScoreServiceImpl();
	
	//2nd
	//@Resource(name = "scoreService") //이름으로 찾음
	//@Autowired
	//private ScoreServiceImpl scoreService;
	
	//3nd - @Controller@Service, @Component, @Repository 자동생성 어노테이션을 붙이고,
	//해당피키지를 스캔 명령으로 읽어서 빈으로 생성 후에 자동주입으로 명령(가장 많이 사용)
	@Autowired
	private ScoreServiceImpl scoreService;
	
	//화면처리
	@RequestMapping("/scoreRegist")
	public void scoreRegist() {
		
	}
	
	//점수등록 요청
	@RequestMapping("/scoreForm")
	public String scoreForm(ScoreVO vo) {
		
		scoreService.ScoreRegist(vo);
		
		return "service/scoreResult";
	}
	
	//점수화면 요청
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		System.out.println("점수요청화면");
		
		ArrayList<ScoreVO> list = scoreService.scoreList();
		model.addAttribute("list", list); //화면에 모델전달
		
		return "service/scoreList";
	}
	
	//점수삭제
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") int num,
											RedirectAttributes RA) {
		
		scoreService.scoreDelete(num); //번호를 리다이렉트된 화면에 전달
		RA.addFlashAttribute("num", num);
		
		return "redirect:/service/scoreList";
	}
	
	
	
}
