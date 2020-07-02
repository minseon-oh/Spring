package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	
	//quiz01--------------------------------------------
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(@ModelAttribute("quiz01") Quiz01VO vo) {
		System.out.println(vo.getYear()+vo.getMonth()+vo.getDay());
		return "quiz/quiz01_ok";
	}
	
	//quiz02--------------------------------------------
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute("id") String id,
					   @ModelAttribute("pw") String pw,
					   @ModelAttribute("name") String name,
					   @ModelAttribute("email") String email ) {
		
		return "quiz/quiz02_ok";
	}
	//quiz03--------------------------------------------
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping(value="/join2", method=RequestMethod.POST)
	public String join2(@ModelAttribute("id") String id,
						@ModelAttribute("pw") String pw,
						@ModelAttribute("pw_check") String pw_check,
						RedirectAttributes RA) {
		
		if(id.equals("")) {
			RA.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		}else if(!pw.equals(pw_check) || pw.equals("")) {
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		}else {
			return "quiz/quiz03_ok";
		}

	}
	
	
}
