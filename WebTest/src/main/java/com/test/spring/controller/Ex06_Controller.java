package com.test.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.spring.domain.SpringDTO;

@Controller
public class Ex06_Controller {
	
	/* @GetMapping(value = "/ex06.do")
	public String test() {
		
		return "ex06";
		
	} */
	
	/* @GetMapping(value = "/ex06.do")
	public void test() {
	
	} */
	
	/* @GetMapping(value = "/ex06.do")
	public String test() {

		return "forward:/ex05.do";
		
	} */
	
	/* @GetMapping(value = "/ex06.do")
	public String test(RedirectAttributes rttr) {
		
		rttr.addAttribute("seq", 5);

		return "redirect:/ex05.do";
		
	} */
	
	/* @GetMapping(value = "/ex06.do")
	public @ResponseBody SpringDTO test() {
		
		SpringDTO dto = new SpringDTO();
		
		dto.setName("홍길동");
		dto.setAge("20");
		dto.setAddress("서울시");
		
		return dto;
		
	} */
	
	@GetMapping(value = "/ex06.do")
	public @ResponseBody List<SpringDTO> test() {
		
		SpringDTO dto1 = new SpringDTO();
		
		dto1.setName("홍길동");
		dto1.setAge("20");
		dto1.setAddress("서울시");
		
		SpringDTO dto2 = new SpringDTO();
		
		dto2.setName("아무개");
		dto2.setAge("22");
		dto2.setAddress("인천시");
		
		List<SpringDTO> list = new ArrayList<SpringDTO>();
		
		list.add(dto1);
		list.add(dto2);
		
		return list;
		
	}

}
