package com.test.mapper;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {

	@Select("SELECT SYSDATE FROM DUAL")
	String getTime1();
	
	String getTime2();

}
