package com.test.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class Ex01_Controller implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setAttribute("name", "홍길동");
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("age", 20);
		
		mv.setViewName("ex01");
		
		return mv;
		
	}

}
