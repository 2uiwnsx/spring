package com.test.spring.di01;

public class Lee {
	
	private Brush brush;
	
	// 생성자 주입
	public Lee(Brush brush) {
		
		this.brush = brush;
		
	}
	
	// setter 주입
	public void setBrush(Brush brush) {
		this.brush = brush;
	}

	public void run() {
		
		brush.draw();
		
	}

}
