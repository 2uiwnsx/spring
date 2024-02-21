package com.test.spring.persistence;

import com.test.spring.domain.SpringDTO;

public class SpringDAOImpl implements SpringDAO {

	@Override
	public int getCount() {

		return 100;
		
	}

	@Override
	public int add(SpringDTO dto) {
		
		System.out.println(dto);
		
		return 1;
		
	}

}
