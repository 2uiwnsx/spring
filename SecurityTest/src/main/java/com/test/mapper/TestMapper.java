package com.test.mapper;

import com.test.domain.AuthDTO;
import com.test.domain.MemberDTO;

public interface TestMapper {

	void addMember(MemberDTO dto);

	void addAuth(AuthDTO dto);

}
