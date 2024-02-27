package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Auth_Controller {
	
	@GetMapping(value = "/auth/login.do")
	public String login() {

		return "auth/login";

	}
	
	@GetMapping(value = "/auth/info.do")
	public String info() {

		return "auth/info";

	}
	
	@GetMapping(value = "/auth/logout.do")
	public String logout() {

		return "auth/logout";

	}
	
	@GetMapping(value = "/auth/accesserror.do")
	public String accesserror() {
		
		return "auth/accesserror";
		
	}

}
