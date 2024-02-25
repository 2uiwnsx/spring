package com.test.spring.aop;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

	public void writeLog() {
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("[LOG] %tF %tT 로그를 기록합니다.\n", now, now);
		
	}
	
	public void measureTime(ProceedingJoinPoint jp) {

		long begin = System.nanoTime();
		
		System.out.println("[TIME] 시간 측정을 시작합니다.");

		try {
			
			jp.proceed();
			
		} catch (Throwable e) {
			
			e.printStackTrace();
			
		}
		
		long end = System.nanoTime();
		
		System.out.println("[TIME] 시간 측정을 종료합니다.");
		System.out.printf("[TIME] 소요 시간: %,dns\n", (end - begin));
		
	}
	
	public void getResult(String result) {
		
		System.out.println("[RESULT] 결과: " + result);
		
	}
	
	public void getExceptionType(Exception e) {
		
		System.out.println("[EXCEPTION] 예외: " + e.getMessage());
		
	}

}
