package com.xhjc.spring.aop;


import com.xhjc.spring.config.AppConfig;
import com.xhjc.spring.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectDemoTest {

	@Test
	public void testAspect(){
		// 创建一个Spring容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		IUserService userService = (IUserService) applicationContext.getBean("userServiceImpl");
		userService.test();

	}
}