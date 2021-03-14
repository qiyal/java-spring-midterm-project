package com.example.demo;

import com.example.demo.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		BookShopApp bookShopApp = ctx.getBean("bookShopApp", BookShopApp.class);
		bookShopApp.start();
	}

}
