package com.test.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.MyBatisDTO;
import com.test.persistence.MyBatisDAO;

@Controller
public class MyBatis_Controller {
	
	@Autowired
	private MyBatisDAO dao;

	@GetMapping(value = "/test.do")
	public String test() {
		
		dao.test();
		
		return "list";
		
	}
	
	@GetMapping(value = "/add.do")
	public String add() {
		
		return "add";
		
	}
	
	@PostMapping(value = "/add_ok.do")
	public String add_ok(MyBatisDTO dto, Model model) {
		
		int result = dao.add(dto);
		
		model.addAttribute("result", result);
		
		return "add_ok";
		
	}
	
	@GetMapping(value = "/m1.do")
	public String m1(Model model) {
		
		int result = dao.m1();
		
		model.addAttribute("result", result);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m2.do")
	public String m2(@RequestParam(name = "seq") String seq, Model model) {
		
		int result = dao.m2(seq);
		
		model.addAttribute("result", result);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m3.do")
	public String m3(Model model) {
		
		MyBatisDTO dto = new MyBatisDTO();
		
		dto.setName("가가가");
		dto.setAge("25");
		dto.setGender("m");
		dto.setAddress("서울시 강남구 대치동");
		
		int result = dao.m3(dto);
		
		model.addAttribute("result", result);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m4.do")
	public String m4(Model model) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("seq", "2");
		map.put("address", "서울시 강남구 압구정동");
		
		int result = dao.m4(map);
		
		model.addAttribute("result", result);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m5.do")
	public String m5(Model model) {
		
		int count = dao.m5();
		
		model.addAttribute("count", count);
		
		return "list";
		
	}

	@GetMapping(value = "/m6.do")
	public String m6(String seq, Model model) {
		
		MyBatisDTO dto = dao.m6(seq);
		
		model.addAttribute("dto", dto);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m7.do")
	public String m7(Model model) {
		
		List<String> nameList = dao.m7();
		
		model.addAttribute("nameList", nameList);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m8.do")
	public String m8(Model model) {
		
		List<MyBatisDTO> list = dao.m8();
		
		model.addAttribute("list", list);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m9.do")
	public String m9(String table, Model model) {
		
		int count = dao.m9(table);
		
		model.addAttribute("count", count);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m10.do")
	public String m10(Model model) {
		
		int count = dao.m10();
		
		model.addAttribute("count", count);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m11.do")
	public String m11(String word, Model model) {
		
		List<MyBatisDTO> list = dao.m11(word);
		
		model.addAttribute("list", list);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m12.do")
	public String m12(String type, Model model) {
		
		List<MyBatisDTO> infoList = dao.m12(type);
		
		model.addAttribute("infoList", infoList);
		
		return "list";
		
	}
	
	@GetMapping(value = "/m13.do")
	public String m13(String column, String word, Model model) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("column", column);
		map.put("word", word);
		
		List<MyBatisDTO> list = dao.m13(map);
		
		model.addAttribute("list", list);
		
		return "list";
		
	}
	
}
