package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.persistence.AOPDAO;

@Controller
public class AOP_Controller {
	
	@Autowired
	private AOPDAO dao;

	@GetMapping(value = "/list.do")
	public String list() {
		
		dao.list();
		
		System.out.println("AOP_Controller.list()");

		return "list";

	}
	
	@GetMapping(value = "/add.do")
	public String add() {
		
		dao.add();
		
		System.out.println("AOP_Controller.add()");

		return "add";

	}
	
	@GetMapping(value = "/view.do")
	public String view() {
		
		dao.view();
		
		System.out.println("AOP_Controller.view()");

		return "view";

	}

}
