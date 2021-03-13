package com.example.demo;

import com.example.demo.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BookShopApp bookShopApp = ctx.getBean("bookShopApp", BookShopApp.class);
        bookShopApp.start();
    }
}
