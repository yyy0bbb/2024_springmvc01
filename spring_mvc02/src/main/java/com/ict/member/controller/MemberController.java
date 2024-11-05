package com.ict.member.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.member.service.MemberService;
import com.ict.member.vo.MemberVO;





@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	//암호화하는 어노테이션
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//jsp 메소드 보고 판단 ,가는 위치도
	@PostMapping("/member_login")
	public ModelAndView getMemberLogIn(MemberVO mvo, HttpSession session) {
		try {
			ModelAndView mv = new ModelAndView();
			MemberVO mvo2 = memberService.getMemberLogIn(mvo.getM_id());
			
			if (mvo2 == null) {
				// request에 값을 저장해서 loginForm에서 로그인 실패를 alert 할 수 있다.
				// 아이디 검사 , 에러페이지 보내서 에러창 뜬 후 로그인 페이지로 이동시킨다.
				return new ModelAndView("sns/login_error");
			}else {
				// 비밀번호 검사
				 if(passwordEncoder.matches(mvo.getM_pw(), mvo2.getM_pw())) {
					 // 성공,             jsp 가서 보기 어디로 갈지
					 session.setAttribute("loginchk", "ok");
					 // 일반유저와 관리자 유저 구분 ,      db다녀온 데이터 mvo2
					 if(mvo2.getM_id().equals("admin")) {
						//set으로 저장하기
						 session.setAttribute("admin", "ok");
					 }
					 // 관리자 로그인 후어디로 갈지 정하기
					 mv.setViewName("redirect:/shop");
					 session.setAttribute("mvo2", mvo2);
					 return mv; 
					 
				 }else {
					 // 로그인 실패
					// request에 값을 저장해서 loginForm에서 로그인 실패를 alert 할 수 있다.
					 return new ModelAndView("/sns/login_error");
				 }
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}

	
	@GetMapping("/member_logout")
	public ModelAndView getMemberLogout(HttpSession session) {
		//세션 초기화(전체삭제)
		session.invalidate();
		
		//필요정보만 삭제
		session.removeAttribute("loginchk");
		session.removeAttribute("admin");
		session.removeAttribute("mvo2");
		
		return new ModelAndView("redirect:/shop");
	}
}

