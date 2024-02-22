package com.test.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAOImpl implements FileDAO {
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<LocDTO> list() {

		return template.selectList("file.list");
		
	}

	@Override
	public int add(LocDTO dto) {

		int result = template.insert("file.add", dto);

		int seq = template.selectOne("file.seq");

		for (PicDTO picDto : dto.getPicList()) {
			
			picDto.setLocSeq(String.format("%d", seq));
			
			result += template.insert("file.addPic", picDto);
			
		}
		
		return result;
		
	}
	
	@Override
	public LocDTO view(String seq) {
		
		LocDTO dto = template.selectOne("file.view", seq);
		
		List<PicDTO> picList = template.selectList("file.picList", seq);
		
		dto.setPicList(picList);
		
		return dto;
		
	}

}
