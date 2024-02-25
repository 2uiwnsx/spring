package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.AddressDTO;
import com.test.persistence.AddressDAO;

@RestController
public class REST_Controller {
	
	@Autowired
	private AddressDAO dao;
	

	@GetMapping(value = "/address")
	public List<AddressDTO> list() {

		return dao.list();

	}
	
	@PostMapping(value = "/address")
	public int add(@RequestBody AddressDTO dto) {
		
		return dao.add(dto);
		
	}
	
	@GetMapping(value = "/address/{seq}")
	public AddressDTO view(@PathVariable(name = "seq") String seq) {
		
		return dao.view(seq);
		
	}
	
	@PutMapping(value = "/address/{seq}")
	public int edit(@PathVariable("seq") String seq, @RequestBody AddressDTO dto) {
		
		dto.setSeq(seq);
		
		return dao.edit(dto);
		
	}
	
	@DeleteMapping(value = "/address/{seq}")
	public int del(@PathVariable String seq) {

		return dao.del(seq);
		
	}

}
