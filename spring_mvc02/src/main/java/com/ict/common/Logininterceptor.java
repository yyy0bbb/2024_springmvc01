package com.ict.common;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;


public class Logininterceptor implements HandlerInterceptor{
	//메서드는 3개이나 직접 호출해야 된다.
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 결과 true 이면 controller로 이동, false이면 특정 jsp로 이동한다.
		
		
		// 로그인 하면 세션에 로그인 성공했다는 정보를 담거나, 또는 사용자 정보를 담는다.
		// 로그인 체크를 해서 만약에 로그인이 안 된 상태이면 value에 false 저장
		
		
		//만약에 session이 삭제된 상태라면 새로운 session을 생성해 준다.
		//삭제가 안 된 상태라면 사용하고 있는 그대로 전달해 준다.
		Object obj = request.getSession(true).getAttribute("loginok");
		
		if (obj == null) { // 로그인 안 된 상태
			// 자바스크립트 코드 작성
			String script = "<script>alert('로그인이 필요합니다.'); location.href='/WEB-INF/views/sns/loginForm.jsp' </script>";
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().write(script);
			
			return false;
		}
		
		return true;
	}
	
	/*
	 * @Override public void postHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
	 * throws Exception { // TODO Auto-generated method stub
	 * HandlerInterceptor.super.postHandle(request, response, handler,
	 * modelAndView); }
	 * 
	 * @Override public void afterCompletion(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, Exception ex) throws Exception
	 * { // TODO Auto-generated method stub
	 * HandlerInterceptor.super.afterCompletion(request, response, handler, ex); }
	 */
	
	
}
