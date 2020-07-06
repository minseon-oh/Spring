package com.simple.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	//------------------------quiz01------------------------
	
	@RequestMapping("/quiz01")
	public String quiz01() {
		return"quiz/quiz01";
	}
	
	@RequestMapping(value="/sendBirth", method=RequestMethod.POST )
	public String sendBrith(@ModelAttribute("info") Quiz01VO vo
									  ) {
		String month = null;
		String day = null;
		if(Integer.parseInt(vo.getMonth()) <= 10) {
			month = "0"+vo.getMonth();
		}
		
		if(Integer.parseInt(vo.getDay()) <= 10){
			day = "0"+vo.getDay();
		}
		
		System.out.println(vo.getYear() + month + day);
		
		return "quiz/quiz01_ok";
	}
	
	
	//------------------------quiz02------------------------
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		return"quiz/quiz02";
	}
	
	@RequestMapping(value = "/join", method =RequestMethod.POST)
	public String join(@ModelAttribute("id") String id,
							  @ModelAttribute("pw") String pw,
							  @ModelAttribute("name") String name,
							  @ModelAttribute("email") String email  ) {
		
		return "quiz/quiz02_ok";
	}
	
	
	//------------------------quiz03------------------------
	
	@RequestMapping("/quiz03")
	public String quiz03() {
		return"quiz/quiz03";
	}

	@RequestMapping("/join2")
	public String join2(@ModelAttribute("id") String id,
								@ModelAttribute("pw") String pw,
								@ModelAttribute("pw_check") String pw_check,
								RedirectAttributes RA) {
		
		if(id.equals("")) {
			RA.addFlashAttribute("noID","아이디 입력은 필수 입니다.");
			return "redirect:/quiz/quiz03";
		}else if(pw.equals("")) {
			RA.addFlashAttribute("noID","비밀번호 입력은 필수 입니다.");
			return "redirect:/quiz/quiz03";
		}else if(pw_check.equals("")) {
			RA.addFlashAttribute("noID", "비밀번호 확인란 입력은 필수 입니다.");
			return "redirect:/quiz/quiz03";
		}else if(!pw.equals(pw_check)) {
			RA.addFlashAttribute("noID", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		}else {
			RA.addFlashAttribute("ID", id);
			return "quiz/quiz03_ok";
		}
		
		
		
	}
	
}
