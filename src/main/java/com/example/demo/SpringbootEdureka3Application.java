package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootEdureka3Application
//extends SpringBootServletInitializer
{
//protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
//{
//	return application.sources(SpringbootEdureka3Application.class);
//}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootEdureka3Application.class, args);
	}

}
