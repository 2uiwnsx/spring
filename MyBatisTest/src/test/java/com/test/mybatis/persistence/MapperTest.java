package com.test.mybatis.persistence;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTest {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testQuery() {
		
		assertNotNull(sqlSessionFactory);

		SqlSession session = sqlSessionFactory.openSession();
		
		assertNotNull(session);
		
		String time = session.selectOne("test.getTime");
		
		log.info(time);
		
	}

}
