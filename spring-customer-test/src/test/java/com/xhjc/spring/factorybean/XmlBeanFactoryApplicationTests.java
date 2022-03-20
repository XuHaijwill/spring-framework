package com.xhjc.spring.factorybean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class XmlBeanFactoryApplicationTests {


	@Test
	public void testApplicationContext(){
		ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");

		Object car1 = beanFactory.getBean("car");
		Object car2 = beanFactory.getBean("car");
		System.out.println(car1 == car2);

		Object bean = beanFactory.getBean("&car");
		System.out.println(bean);

	}

	@Test
	public void testApplicationReaource(){
		ClassPathResource resource = new ClassPathResource("spring-config.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);

		Object car1 = beanFactory.getBean("car");
		Object car2 = beanFactory.getBean("car");
		System.out.println(car1 == car2);

		Object bean = beanFactory.getBean("&car");
		System.out.println(bean);

	}
}
