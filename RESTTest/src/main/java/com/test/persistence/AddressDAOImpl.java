package com.test.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.AddressDTO;

@Repository
public class AddressDAOImpl implements AddressDAO {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<AddressDTO> list() {
		
		return template.selectList("rest.list");
		
	}

	@Override
	public int add(AddressDTO dto) {
		
		return template.insert("rest.add", dto);
		
	}
	
	@Override
	public AddressDTO view(String seq) {
		
		return template.selectOne("rest.view", seq);
		
	}

	@Override
	public int edit(AddressDTO dto) {
		
		return template.update("rest.edit", dto);
		
	}

	@Override
	public int del(String seq) {
		
		return template.delete("rest.del", seq);
		
	}

}
