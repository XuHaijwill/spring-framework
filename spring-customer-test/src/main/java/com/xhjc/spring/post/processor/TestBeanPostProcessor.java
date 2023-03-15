package com.xhjc.spring.post.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("personDAOImpl".equals(beanName)) {
			System.out.println("初始化前");
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("personDAOImpl".equals(beanName)) {
			System.out.println("初始化后");
		}

		return bean;
	}
}
