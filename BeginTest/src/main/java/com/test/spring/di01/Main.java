package com.test.spring.di01;

public class Main {
	
	public static void main(String[] args) {

		Hong hong = new Hong();
		
		hong.run();
		
		Brush brush = new Brush();
		
		Lee lee = new Lee(brush);
		
		lee.run();
		
	}

}
