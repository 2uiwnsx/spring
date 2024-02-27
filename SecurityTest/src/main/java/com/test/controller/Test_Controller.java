package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test_Controller {
	
	@GetMapping(value = "/index.do")
	public String index() {
		
		return "index";
		
	}
	
	@GetMapping(value = "/member/member.do")
	public String member() {
		
		return "member/member";
		
	}
	
	@GetMapping(value = "/admin/admin.do")
	public String admin() {
		
		return "admin/admin";
		
	}

}
