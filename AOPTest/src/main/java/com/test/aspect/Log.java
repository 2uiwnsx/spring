package com.test.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 횡단 관심사
@Aspect
@Component
public class Log {
	
	// 핵심 관심사
	@Pointcut("execution(* com.test.controller.AOP_Controller.add(..))")
	public void pc1() {
		
	}

	@After("pc1()")
	public void m1() {
		
		System.out.println("After Advice");
		
	}
	
	@Before("pc1()")
	public void m2() {
		
		System.out.println("Before Advice");
		
	}
	
	@After("execution(* com.test.controller.AOP_Controller.view(..))")
	public void m3() {
		
		System.out.println("After Advice");
		
	}

}
