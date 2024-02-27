package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;
import com.test.mapper.MemberMapper;

@Controller
public class Member_Controller {
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping(value = "/auth/register.do")
	public String register() {

		return "auth/register";

	}
	
	@PostMapping(value = "/auth/register_ok.do")
	public String register_ok(MemberDTO dto, int auth) {
		
		String pswd = dto.getPswd();
		
		pswd = encoder.encode(pswd);
		
		dto.setPswd(pswd);
		
		mapper.addMember(dto);
		
		if (auth >= 1) {
			
			AuthDTO auth_dto = new AuthDTO();
			
			auth_dto.setId(dto.getId());
			auth_dto.setAuth("ROLE_MEMBER");
			
			mapper.addAuth(auth_dto);
			
		}
		
		if (auth >= 2) {
			
			AuthDTO auth_dto = new AuthDTO();
			
			auth_dto.setId(dto.getId());
			auth_dto.setAuth("ROLE_ADMIN");
			
			mapper.addAuth(auth_dto);
			
		}

		return "redirect:/index.do";

	}

}
