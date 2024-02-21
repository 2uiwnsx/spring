package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/ex03.do")
public class Ex03_Controller {

	@RequestMapping
	public String test() {
		
		return "ex03";
		
	}
	
	public int sum(int a, int b) {
		
		return (a + b);
		
	}
	
}
