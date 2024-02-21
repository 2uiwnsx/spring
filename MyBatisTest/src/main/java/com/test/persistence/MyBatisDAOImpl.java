package com.test.persistence;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.domain.MyBatisDTO;

@Repository
public class MyBatisDAOImpl implements MyBatisDAO {
	
	@Autowired
	private SqlSessionTemplate template;

	@Override
	public void test() {

		System.out.println(template == null);
		
	}

	@Override
	public int add(MyBatisDTO dto) {
		
		return template.insert("mybatis.add", dto);
		
	}

	@Override
	public int m1() {
		
		return template.update("mybatis.m1");
		
	}

	@Override
	public int m2(String seq) {
		
		return template.delete("mybatis.m2", seq);
		
	}

	@Override
	public int m3(MyBatisDTO dto) {
		
		return template.insert("mybatis.m3", dto);
		
	}

	@Override
	public int m4(HashMap<String, String> map) {
		
		return template.update("mybatis.m4", map);
		
	}

	@Override
	public int m5() {
		
		return template.selectOne("mybatis.m5");
		
	}

	@Override
	public MyBatisDTO m6(String seq) {
		
		return template.selectOne("mybatis.m6", seq);
		
	}

	@Override
	public List<String> m7() {
		
		return template.selectList("mybatis.m7");
		
	}

	@Override
	public List<MyBatisDTO> m8() {
		
		return template.selectList("mybatis.m8");
		
	}

	@Override
	public int m9(String table) {
		
		return template.selectOne("mybatis.m9", table);
		
	}

	@Override
	public int m10() {
		
		return template.selectOne("mybatis.m10");
		
	}

	@Override
	public List<MyBatisDTO> m11(String word) {
		
		return template.selectList("mybatis.m11", word);
		
	}

	@Override
	public List<MyBatisDTO> m12(String type) {
		
		return template.selectList("mybatis.m12", type);
		
	}

	@Override
	public List<MyBatisDTO> m13(HashMap<String, String> map) {
		
		return template.selectList("mybatis.m13", map);
		
	}

}
