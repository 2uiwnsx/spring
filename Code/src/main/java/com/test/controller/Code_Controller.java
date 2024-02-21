package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.domain.CodeDTO;
import com.test.persistence.CodeDAO;

@Controller
public class Code_Controller {
	
	@Autowired
	private CodeDAO dao;
	
	@GetMapping(value = "/list.do")
	public String list(@RequestParam(name = "language", required = false) List<String> language, Model model) {
		
		model.addAttribute("language", language);
		
		List<CodeDTO> list = dao.list(language);

		model.addAttribute("list", list);
		
		return "list";
		
	}
	
	@GetMapping(value = "/add.do")
	public String add() {
		
		return "add";
		
	}
	
	@PostMapping(value = "/add_ok.do")
	public String add_ok(CodeDTO dto) {
		
		int result = dao.add(dto);
		
		if (result == 1) {
			
			return "redirect:/list.do";
			
		} else {
			
			return "redirect:/add.do";
			
		}
		
	}
	
	@GetMapping(value = "/view.do")
	public String view(String seq, Model model) {
		
		CodeDTO dto = dao.view(seq);
		
		model.addAttribute("dto", dto);
		
		return "view";
		
	}

}
