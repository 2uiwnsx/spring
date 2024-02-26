package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Chat_Controller {
	
	@GetMapping(value = "/index.do")
	public String index() {

		return "index";

	}
	
	@GetMapping(value = "/chat.do")
	public String chat() {

		return "chat";

	}

}
