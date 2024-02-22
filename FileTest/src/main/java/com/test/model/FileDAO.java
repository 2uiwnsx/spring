package com.test.model;

import java.util.List;

public interface FileDAO {
	
	List<LocDTO> list();

	int add(LocDTO dto);

	LocDTO view(String seq);

}
