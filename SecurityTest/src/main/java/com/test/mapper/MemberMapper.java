package com.test.mapper;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;

public interface MemberMapper {

	int addMember(MemberDTO dto);

	void addAuth(AuthDTO dto);

	MemberDTO getUserDetails(String username);

}
