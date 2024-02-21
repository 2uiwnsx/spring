package com.test.persistence;

import java.util.List;

import com.test.domain.CodeDTO;

public interface CodeDAO {
	
	List<CodeDTO> list(List<String> language);

	int add(CodeDTO dto);

	CodeDTO view(String seq);

}
