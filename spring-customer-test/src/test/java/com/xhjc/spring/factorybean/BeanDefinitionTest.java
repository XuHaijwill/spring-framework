package com.xhjc.spring.factorybean;

import com.xhjc.spring.config.AppConfig;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {

	@Test
	public void beanTest(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// 生成一个BeanDefinition对象，并设置beanClass为Person.class，并注册到ApplicationContext中
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(com.xhjc.spring.model.Person.class);
		//我们还可以通过BeanDefinition设置一个Bean的其他属性
		beanDefinition.setScope("prototype"); // 设置作用域
		beanDefinition.setInitMethodName("init"); // 设置初始化方法
		beanDefinition.setLazyInit(true); // 设置懒加载
		context.registerBeanDefinition("user", beanDefinition);

		System.out.println(context.getBean("user"));
	}
}
