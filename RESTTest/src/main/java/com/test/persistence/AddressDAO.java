package com.test.persistence;

import java.util.List;

import com.test.domain.AddressDTO;

public interface AddressDAO {
	
	List<AddressDTO> list();

	int add(AddressDTO dto);
	
	AddressDTO view(String seq);

	int edit(AddressDTO dto);

	int del(String seq);

}
