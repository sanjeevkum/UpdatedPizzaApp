package com.springmvc.pizzaapplication.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springmvc.pizzaapplication.dao.PizzaDAO;
import com.springmvc.pizzaapplication.dao.PizzaDAOImp;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.springmvc.pizzaapplication")
public class SpringMvcConfig implements WebMvcConfigurer{
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pizzaapp");
		dataSource.setUsername("root");
		dataSource.setPassword("mysqlroot");
		
		return dataSource;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Bean
	public PizzaDAO getPizzDAO() {
		return new PizzaDAOImp(getDataSource());
	}
	
	
}
