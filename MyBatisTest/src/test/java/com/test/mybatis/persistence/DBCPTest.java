package com.test.mybatis.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBCPTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		
		try {
			
			assertNotNull(dataSource);

			Connection conn = dataSource.getConnection();
			
			assertNotNull(conn);
			
			log.info(conn.isClosed());

		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}

}
