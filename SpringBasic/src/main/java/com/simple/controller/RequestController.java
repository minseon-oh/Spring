package com.simple.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //component스캔이 해당 어노테이션을 읽어서 빈으로 생성
@RequestMapping("/request") //모든 메서드 앞에 /request를 붙인다
public class RequestController {
	
	//모든요청은 컨트롤러로 들어오게되는데, 이 메서드를 실행시키고 싶다면 /request/req_ex01 요청을 화면에서 호출한다.
	//폴더명을 맟춰서 요청경로를 기술하는 편이 좋다.
	//void형이라면 호출된 URL과 동일한 페이지로 연결된다.
	
	//req_ex01화면요청 (void형)
//	@RequestMapping("/request/req_ex01")
//	public void req_ex01() {
//		
//	}
	
	//위와 아래는 같다.
//	@RequestMapping("/request/req_ex01")
//	public String req_ex01() {
//		return "/request/req_ex01";
//	}
	
	@RequestMapping("/req_ex01") //클래스에 리퀘스트맵핑을 했기때문에 /request/req_ex01와 같다
	public String req_ex01() {
		return "/request/req_ex01";
	}
	
//	//basic1 요청처리 (get요청만받음)
//	@RequestMapping(value="/basic1", method=RequestMethod.GET)
//	public void basic1() {
//		System.out.println("basic1화면");
//	}
//	
//	//basic2 요청처리 (post요청만받음)
//	@RequestMapping(value="/basic2", method=RequestMethod.POST)
//	public void basic2() {
//		System.out.println("basic2화면");
//	}
//	
//	//basic3 요청처리 (getMapping)
//	@GetMapping("/basic3")
//	public void basic3() {
//		System.out.println("basic3화면");
//	}
//	
//	//basic4 요청처리 (PostMapping)
//	@PostMapping("/basic4")
//	public void basic4() {
//		System.out.println("basic4화면");
//	}
	
	
	//동일요청을 맵핑하나로 처리하고싶다면 {} 경로를 묶어주면된다.
	@RequestMapping({"/basic1","/basic2","/basic3"})
	public void view() {
		System.out.println("실행");
	}
	
	//------------요청파라미터받기---------------
	//req_ex02화면처리
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		return "request/req_ex02";
	}
	
//	//param1요청처리 (첫번째방법)
//	@RequestMapping(value="/param1", method = RequestMethod.POST)
//	public String param1(HttpServletRequest request) {
//		System.out.println(request.getParameter("id"));
//		return "request/req_ex02_result"; 
//	}
	
	//param1요청처리 (두번째방법)
	@RequestMapping("/param1")
	public String param1(	@RequestParam("id")String id,
					        @RequestParam("pw")String pw,
					        @RequestParam("name")String name,
					        @RequestParam("age")String age,
					        @RequestParam(value="inter",required = false,defaultValue="") ArrayList<String> inter) {
	      System.out.println(id);
	      //필수가 아닌 파라미터는 required = false 속성 지정하면 되비다.
	      //필수가 아닌 파라미터일 경우 null값을 지정하게 되는데 기본값의 설정으로 defaultValue옵션을 사용하면 됩니다.
	      System.out.println(inter.toString());
	      
	      return "request/req_ex02_result";   
	   }

	
//	//param1요청처리 (세번째방법)
//	@RequestMapping(value="/param1")
//	public String param1(ReqVO vo) {
//		System.out.println(vo.getId());
//		System.out.println(vo.getPw());
//		System.out.println(vo.getName());
//		System.out.println(vo.getAge());
//		System.out.println(vo.getInter().toString());
//		return "request/req_ex02_result"; 
//	}
	
	//---------------------------------------------------------------------
	//req_quiz01
	
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		return "request/req_quiz01";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("abc123") && pw.equals("xxx123")) {
			return "request/req_quiz01_ok";
		}else {
			return "request/req_quiz01_no";
		}
		
	}

}
