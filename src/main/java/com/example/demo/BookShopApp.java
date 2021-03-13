package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BookShopApp {
    @Autowired
    @Qualifier("initScanner")
    private Scanner sc;

    public BookShopApp() {}

    public void start() {
        System.out.println("1 - Sign in");
        System.out.println("2 - Sign up");
        System.out.println("0 - EXIT");
        String option = sc.next();

        switch (option) {
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
            case "0":
                System.out.println("0");
                break;
            default:
                System.out.println("Invalid argument!");
        }
    }
}
