package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Client_Controller {
	
	@GetMapping(value = "/list.do")
	public String list() {
		
		return "list";

	}
	
	@GetMapping(value = "/add.do")
	public String add() {

		return "add";

	}
	
	@GetMapping(value = "/view.do")
	public String view(String seq, Model model) {
		
		model.addAttribute("seq", seq);

		return "view";

	}

}
