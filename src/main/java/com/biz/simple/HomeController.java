package com.biz.simple;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	/*
	 * value="/" : rootPath
	 * 프로젝트에서 아무런 URI가 없이 호출되는 주소(path)
	 * localhost:8080/simple/
	 * <<프로젝트가 최초 시작되었을때 views/home.jsp를 열어서 web browser로 보내라라는 뜻>>
	 * 
	 * 
	 * 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping("list")
	public String list() {
		return "list"; //누군가가 이 리스트라는 메서드를 호출하면 문자열 list를 return 하라
	}
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write() {
		return "write"; //web에서 /wirte라고 검색을 하면 write.jsp파일을 열어서 보내라
	}
	
	@RequestMapping(value="write",method=RequestMethod.POST)
	// form에 input box가 3개있기때문에 매개변수 3개를 받는것.
	// 매개변수를 메서드안에 다 받을 수 없기때문에 VO를 만들고 매개변수로 VO를 받아주는것.
	// 입력폼에서 넘겨줄 데이터가 몇개일지 모를때.. 늘어날수도 있고 줄어들수도 있기때문에 VO를 만들어서 하는것 오호~
	public String wirte1(InputVO inputVO, Model model) {
		
		System.out.println(inputVO.getNum1());
		System.out.println(inputVO.getOp());
		System.out.println(inputVO.getNum2());
		
		int intNum1 = Integer.valueOf(inputVO.getNum1());
		int intNum2 = Integer.valueOf(inputVO.getNum2());
		
		String op = inputVO.getOp();
		int result = 0;
		
		if(op.equals("+")) {
			result = intNum1 + intNum2;
		}
		if(op.equals("-")) {
			result = intNum1 - intNum2;
			
		}if(op.equals("*")) {
			result = intNum1 * intNum2 ;
		}
		model.addAttribute("result", "결과:" + result);
		// result라는 값을 model의 addAttribute라는 친구들 통해서 
		// view.jsp에 가서 ${result}를 입력하면 연산된 결과를 볼 수 있다.
		// 자바가 스프링에게 스프링만이 알고 있는 어떤 규칙으로 result = 결과보기 + result로 만든것과 같음
		// 스프링에게 다시 view파일을 읽어서 사용자에게 보내라라고 알려준 것.
		// 자바가 result..값을 줌으로서해서 스프링은 그 파일을 검사를 하고 방금 설정한 result라는 친구를 
		// ${중괄호}에 둘러쌓여있는 친구를 찾아서 그 결과값을 웹브라우저에 보여줌 = 이런 과정을 랜더링이라고 함.
		// 이게 스프링이 하는 일 ~~ ~  ~ 재밌다 재밌다 재밌어 
		return "view";
		
		
	}
}
