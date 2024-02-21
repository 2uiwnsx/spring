package com.test.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.spring.persistence.SpringDAO;

public class Ex02_Controller implements Controller {
	
	private SpringDAO dao;
	
	public Ex02_Controller(SpringDAO dao) {
		
		this.dao = dao;
		
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int count = dao.getCount();
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("count", count);
		
		mv.setViewName("ex02");
		
		return mv;
		
	}

}
