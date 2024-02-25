package com.test.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {

		Pen p1 = new Pen();
		
		p1.write();
		
		System.out.println();
		
		Pen p2 = new Pen();
		
		Hong hong1 = new Hong(p2);
		
		hong1.run();
		
		System.out.println();
		
		Choi choi = new Choi();
		
		Brush b1 = new Brush();
		
		choi.setBrush(b1);
		
		Park park1 = new Park(choi);
		
		park1.run();
		
		System.out.println();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/com/test/spring/di02/di02.xml");

		Pen p3 = (Pen)context.getBean("pen");
		
		p3.write();

		Brush b2 = (Brush)context.getBean("brush");
		
		b2.draw();
		
		Brush b3 = (Brush)context.getBean("b1");
		
		b3.draw();
		
		Brush b4 = (Brush)context.getBean("myBrush");
		
		b4.draw();
		
		System.out.println();
		
		Hong hong2 = (Hong)context.getBean("hong");
		
		hong2.run();
		
		System.out.println();
		
		Park park2 = (Park)context.getBean("park");
		
		park2.run();
		
	}

}
