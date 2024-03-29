package com.test.mybatis.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	
	@Test
	public void testConnection() {
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "server", "java1234");
			
			assertNotNull(conn);
			
			log.info(conn.isClosed());

		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}

}
