package com.test.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class Board_Controller {

	@RequestMapping(value = "/list.do")
	public String getList() {
		
		return "board/list";
		
	}
	
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public String add() {
		
		return "board/add";
		
	}

	@RequestMapping(value = "/add_ok.do", method = RequestMethod.POST)
	public String add_ok() {
		
		return "board/add_ok";
		
	}

	@RequestMapping(value = "/view.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String getView() {
		
		return "board/view";
		
	}

}
