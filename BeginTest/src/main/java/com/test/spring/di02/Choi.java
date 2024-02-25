package com.test.spring.di02;

public class Choi {
	
	private Brush brush;
	
	public void setBrush(Brush brush) {
		this.brush = brush;
	}

	public void doSomething() {
		
		System.out.println("Choi 근무 중");
		
		brush.draw();
		
	}

}
