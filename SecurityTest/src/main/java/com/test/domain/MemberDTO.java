package com.test.domain;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String id;
	private String pswd;
	private String name;
	private String regdate;
	private boolean enabled;
	
	private List<AuthDTO> authList;

}
