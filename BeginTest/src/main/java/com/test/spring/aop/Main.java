package com.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/spring/aop/memo.xml");
		
		Memo memo = (Memo)context.getBean("memo");
		
		memo.add("Spring AOP");

		try {
			
			String txt = memo.read(15);
			
			System.out.println(txt);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		memo.edit(5, "수정한 내용");
		
		memo.del(5);
		
	}

}
