package com.simple.basic;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller //component 스캔이 해당 어노테이션을 읽이서 빈으로 생성
@RequestMapping("/request") //이컨트롤러에 들어오는 맵핑앞에 다 붙여준다
public class RequestController {
	
	//모든 요청은 컨트롤러로 들어오게 되는데, 이메서드를 실행시키고 싶다면 /request/req_ex01요청을 화면에서 호출니다.
	//폴더명을 맞춰서 요청경로를 기술하는 편이 좋습니다.
	// void형이라면 호출된 URL과 동일한 페이지로 연결
	//req_ex01화면요청
	
	
//	@RequestMapping("/request/req_ex01")
//	public void req_ex01() {
//		
//	}
//	
	@RequestMapping("/req_ex01")
	public String req_ex01() {
		return "request/req_ex01";
	}
	
	//basic1요청처리 ( get요청만 처리)
	@RequestMapping(value = "/basic1", method = RequestMethod.GET)
	public void basic1(){
		System.out.println("basic1요청중....");
	}
	//basic2요청 처리 (Post요청만 처리)
	@RequestMapping(value = "basic2", method = RequestMethod.POST)
	public void basic2() {
		System.out.println("basic2요청중....");
	}
		
	//basic3요청 처리(getMapping)
	@GetMapping("/basic3")
	public void basic3() {
		System.out.println("basic3 요청중입니다..");
	}
	
	//basic4요청 처리(PostMapping)
	@PostMapping("/basic4")
	public void basic4() {
		System.out.println("basic4 오류 수정중입니다.");
	}
	
//	//동일 요청을 Mapping 하나로 처리하고 싶다면  { }로 경로를 묶어 주면됩니다. (사용주의)
//	@RequestMapping({"/basic1", "/basic2","/basic3","/basic4"})
//	public void view() {
//		System.out.println("서버 점검중 입니다.");
//	}
	
	//---------------------요청 파라미터 받기-----------------------------
	
	//req_ex02화면처리
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		return "/request/req_ex02"; //보여줄 화면
	}
	
	//param1요청 처리
//	@RequestMapping(value="/param1", method = RequestMethod.POST)
//	public String param1(HttpServletRequest request) {
//		System.out.println(request.getParameter("id"));
//		return "request/req_ex02_result";
//	}
	
	
	//2nd (어노테이션)
	@RequestMapping("/param1")
	public String param1(@RequestParam("id") String id,
									  @RequestParam("pw") String pw,
									  @RequestParam("name") String name,
									  @RequestParam("age") String age,
									  @RequestParam(value = "inter", required = false, defaultValue = "선택없음") ArrayList<String> inter ) {
		
		//필수가 아닌 파라미터는 required = false속성을 지정하면 됩니다.
		//필수가 아닌 파라미터 일 경우 null값을 지정하게 되는데 기본값의 설정으로 dafaultValue 옵션을 사용하면 됩니다.
		System.out.println("ID : " + id + ", PW : " + pw + ", NAME : " + name +", AGE : " +age +", 관심분야 : " + inter.toString());
		return "request/req_ex02_result";
		
	}
	
	
	//3nd
//	@RequestMapping("/param1")
//	public String param1(ReqVO vo) {
//
//		System.out.println(vo.getId());
//		System.out.println(vo.getPw());
//		System.out.println(vo.getName());
//		System.out.println(vo.getAge());
//		System.out.println(vo.getInter().toString());
//		return "request/req_ex02_result";
//	}
//	
	
	
	//---------------------QUIZ01-----------------------------
	
	
	@RequestMapping("/req_quiz01")
	public String req_quiz01() {
		
		return "/request/req_quiz01"; //보여줄 화면
	}
	
	@RequestMapping("/login")
	public String login (@RequestParam("id") String id,
								@RequestParam("pw") String pw) {
		
		if(id.equals("abc123") && pw.equals("xxx123")) {
			return "/request/req_quiz01_ok";
		}else {
			return "/request/req_quiz01_no";
		}
		
	}
	
	
	
	
	
	
	
}
