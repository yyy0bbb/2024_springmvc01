package com.ict.edu02.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.edu02.service.CalcService;
import com.ict.edu02.service.MemberService;
import com.ict.edu02.vo.CalcVO;
import com.ict.edu02.vo.MembersVO;

@Controller
public class MyController3 {
	
	// 서비스와 같이 다른 곳에서 만들어진 객체를 가져와서 사용하기 위한 어노텐이션
	// @Inject    : java
	// @Autowired : Spring
	
	@Autowired
	private CalcService calcService ;
	
	@Autowired
	private MemberService memberService;
	/*
	@PostMapping("/calc2")
	public ModelAndView calc2Exec(CalcVO cvo) {  
		// CalcVO에 파라미터들이 알아서 넣어진다.(변수와 파라미터이름같아야 한다.)
		ModelAndView mv = new ModelAndView("day02/result");
		
		// 파라미터가 저장되어 있는지 확인 
		// System.out.println(cvo.getS1());
		
		// 일처리는 service 에서 넘기자 
		int result = calcService.getCalc(cvo);
		
		 mv.addObject("cvo", cvo);
		 mv.addObject("result", result);
		return mv;
	}
	*/
	
	@PostMapping("/calc2")
	public ModelAndView calc2Exec(@ModelAttribute("cvo")CalcVO cvo) {  
		// CalcVO에 파라미터들이 알아서 넣어진다.(변수와 파라미터이름같아야 한다.)
		// Model 클래스의 속성을 이용해서 ("cvo", cvo) 저장되는 어노테이션이다.
		
		ModelAndView mv = new ModelAndView("day02/result");
		
		// 파라미터가 저장되어 있는지 확인 
		// System.out.println(cvo.getS1());
		
		//CalcService cService = new CalcService();
		//int result = cService.getCalc(cvo);
		
		// 일처리는 service 에서 넘기자 
		 int result = calcService.getCalc(cvo);
		
		// mv.addObject("cvo", cvo);
		// 대신 @ModelAttribute("cvo")CalcVO cvo
		
		 mv.addObject("result", result);
		return mv;
	}
	
	@GetMapping("/member_list")
	public ModelAndView memberList() {
		ModelAndView mv = new ModelAndView("day02/memberResult");
		
		List<MembersVO> list = memberService.getMemberList();
		
		mv.addObject("list", list);
		return mv;
	}
}









