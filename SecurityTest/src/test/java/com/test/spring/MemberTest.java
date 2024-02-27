package com.test.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;
import com.test.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MemberTest {
	
	@Autowired
	private TestMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void insertMember() {
		
		MemberDTO dto1 = new MemberDTO();
		
		dto1.setId("dog");
		dto1.setPswd(encoder.encode("1111"));
		dto1.setName("강아지");
		
		mapper.addMember(dto1);
		
		MemberDTO dto2 = new MemberDTO();
		
		dto2.setId("cat");
		dto2.setPswd(encoder.encode("1111"));
		dto2.setName("고양이");
		
		mapper.addMember(dto2);
		
		MemberDTO dto3 = new MemberDTO();
		
		dto3.setId("tiger");
		dto3.setPswd(encoder.encode("1111"));
		dto3.setName("호랑이");
		
		mapper.addMember(dto3);
		
	}
	
	@Test
	public void insertAuth() {
		
		AuthDTO dto1 = new AuthDTO();
		
		dto1.setId("dog");
		dto1.setAuth("ROLE_MEMBER");
		
		mapper.addAuth(dto1);
		
		AuthDTO dto2 = new AuthDTO();
		
		dto2.setId("cat");
		dto2.setAuth("ROLE_MEMBER");
		
		mapper.addAuth(dto2);
		
		AuthDTO dto3 = new AuthDTO();
		
		dto3.setId("tiger");
		dto3.setAuth("ROLE_MEMBER");
		
		mapper.addAuth(dto3);
		
		AuthDTO dto4 = new AuthDTO();
		
		dto4.setId("tiger");
		dto4.setAuth("ROLE_ADMIN");
		
		mapper.addAuth(dto4);
		
	}

}
