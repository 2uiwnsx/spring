package com.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.domain.AddressDTO;

@Controller
public class Address_Controller {
	
	@GetMapping(value = "/m1.do")
	public @ResponseBody String m1() {

		String name = "Hong";
		
		return name;

	}
	
	@GetMapping(value = "/m2.do")
	public @ResponseBody AddressDTO m2() {

		AddressDTO dto = new AddressDTO();
		
		dto.setSeq("1");
		dto.setName("홍길동");
		dto.setGender("m");
		dto.setAge("20");
		dto.setAddress("서울시 강남구 역삼동");
		dto.setRegdate("2023-11-29");
		
		return dto;

	}
	
	@GetMapping(value = "/m3.do")
	public @ResponseBody List<AddressDTO> m3() {

		AddressDTO dto1 = new AddressDTO();
		
		dto1.setSeq("1");
		dto1.setName("홍길동");
		dto1.setGender("m");
		dto1.setAge("20");
		dto1.setAddress("서울시 강남구 역삼동");
		dto1.setRegdate("2023-11-29");
		
		AddressDTO dto2 = new AddressDTO();
		
		dto2.setSeq("2");
		dto2.setName("아무개");
		dto2.setGender("f");
		dto2.setAge("25");
		dto2.setAddress("서울시 강남구 대치동");
		dto2.setRegdate("2023-11-29");
		
		List<AddressDTO> list = new ArrayList<AddressDTO>();
		
		list.add(dto1);
		list.add(dto2);
		
		return list;

	}

}
