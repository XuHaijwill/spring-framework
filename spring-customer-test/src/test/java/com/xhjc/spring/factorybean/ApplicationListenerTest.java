package com.xhjc.spring.factorybean;

import com.xhjc.spring.config.AppConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationListenerTest {

	@Test
	public void test(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.publishEvent("kkk");
	}
}
