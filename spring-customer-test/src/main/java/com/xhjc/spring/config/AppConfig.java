package com.xhjc.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.xhjc.spring")
@PropertySource("classpath:database.properties")
//enable Aspect, if you want cglib  please set proxyTargetClass=true otherwise jdk
@EnableAspectJAutoProxy
public class AppConfig {

	@Autowired
	Environment environment;

	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";


	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	DataSource datasource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(this.URL));
		driverManagerDataSource.setUsername(environment.getProperty(this.USER));
		driverManagerDataSource.setPassword(environment.getProperty(this.PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(this.DRIVER));
		return driverManagerDataSource;
	}

	@Bean
	@SuppressWarnings({"rawtypes", "unchecked"})
	public ApplicationListener applicationListener() {
		return new ApplicationListener() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				System.out.println("接收到了一个事件" + event.toString());
			}
		};
	}
}
