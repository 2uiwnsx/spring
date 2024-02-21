package com.test.spring.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex05_Controller {
	
	@GetMapping(value = "/ex05.do")
	public String ex05() {
		
		return "ex05";
		
	}
	
	// 단일값
	
	/* @PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(HttpServletRequest req) {
		
		String data = req.getParameter("data");
		
		req.setAttribute("data", data);
		
		return "ex05_ok";
		
	} */

	/* @PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(@RequestParam(name = "data") String data, Model model) {
		
		model.addAttribute("data", data);
		
		return "ex05_ok";
		
	} */
	
	/* @PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(@RequestParam("data") String data, Model model) {
		
		model.addAttribute("data", data);
		
		return "ex05_ok";
		
	} */
	
	/* @PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(String data, Model model) {
		
		model.addAttribute("data", data);
		
		return "ex05_ok";
		
	} */
	
	/* @PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(@ModelAttribute(name = "data") String data) {

		return "ex05_ok";
		
	} */
	
	// 복합값
	
	/* @PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(String seq, String name, String age, String address, Model model) {
		
		System.out.println(seq);
		
		SpringDTO dto = new SpringDTO();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setAddress(address);
		
		SpringDAO dao = new SpringDAOImpl();
		
		int result = dao.add(dto);
		
		model.addAttribute("result", result);
		
		return "ex05_ok";
		
	} */
		
	/* @PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(String seq, SpringDTO dto, Model model) {
	
		System.out.println(seq);
		
		SpringDAO dao = new SpringDAOImpl();
		
		int result = dao.add(dto);
		
		model.addAttribute("result", result);
		
		return "ex05_ok";
		
	} */
	
	// 다중값
	
	/* @PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(HttpServletRequest req) {
		
		String[] cb = req.getParameterValues("cb");
		
		System.out.println(Arrays.toString(cb));
		
		return "ex05_ok";
		
	} */
		
	/* @PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(@RequestParam("cb") String[] cb) {
		
		System.out.println(Arrays.toString(cb));
		
		return "ex05_ok";
		
	} */
	
	@PostMapping(value = "/ex05_ok.do")
	public String ex05_ok(String[] cb) {
		
		System.out.println(Arrays.toString(cb));
		
		return "ex05_ok";
		
	}

}
