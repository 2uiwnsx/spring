package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex04_Controller {
	
	@RequestMapping(value = "/ex04_1.do")
	public String ex04() {
		
		return "ex04_1";
		
	}
	
	@RequestMapping("/ex04_2.do")
	public String ex04_1() {
		
		return "ex04_2";
		
	}

}
