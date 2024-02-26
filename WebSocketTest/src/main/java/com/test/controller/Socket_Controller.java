package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Socket_Controller {
	
	@GetMapping(value = "/test.do")
	public String test() {

		return "test";

	}

}
