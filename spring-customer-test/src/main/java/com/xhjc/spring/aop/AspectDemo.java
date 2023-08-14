package com.xhjc.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectDemo {

	@Pointcut("execution(* com.xhjc.spring.service.IUserService.test())")
	public void a(){

	}

	@Before("a()")
	public void demoBefore(JoinPoint joinPoint) {
		System.out.println("Before Aspect Test ");
	}
}
