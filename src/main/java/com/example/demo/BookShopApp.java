package com.example.demo;

import com.example.demo.controller.BookController;
import com.example.demo.controller.ClientController;
import com.example.demo.entity.Book;
import com.example.demo.service.implement.CalculateOrderCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class BookShopApp {
    @Autowired
    @Qualifier("initScanner")
    private Scanner sc;
    @Autowired
    private ClientController clientController;
    @Autowired
    private BookController bookController;
    @Autowired
    private CalculateOrderCost calculateOrderCost;
    private boolean authStatus;
    private boolean isClient;
    private boolean stopApp;
    private String clientLogin;

    public BookShopApp() {
        this.authStatus = false;
        this.isClient = false;
        this.clientLogin = null;
        this.stopApp = false;
    }

    private void singIn() {
        String login, password;
        System.out.print("Login: ");
        login = sc.next();
        System.out.print("Password: ");
        password = sc.next();

        if (clientController.hasClient(login, password)) {
            this.authStatus = true;
            this.isClient = true;
            this.clientLogin = login;
            System.out.println("Login: " + login);
        } else {
            System.out.println("Login or password is not correct!");
        }
    }

    public void start() {
        String option;
        String chose;

        while (!stopApp) {
            if (!authStatus) {
                System.out.println("1 - Sign in");
                System.out.println("2 - Sign up");
                System.out.println("0 - EXIT");
                System.out.print("enter: ");
                option = sc.next();

                switch (option) {
                    case "1":
                        singIn();
                        break;
                    case "2":
                        System.out.println("2");
                        break;
                    case "0":
                        System.out.println("0");
                        stopApp = true;
                        break;
                    default:
                        System.out.println("Invalid argument!");
                }
            } else if (authStatus && isClient) {
                List<Book> books = bookController.getAllBooks();

                for (int i = 0; i < books.size(); i++) {
                    System.out.println(i + ") " + books.get(i).getName() + "\tPrice: " + books.get(i).getPrice());
                }
                System.out.println("1 - Add book to cart");
                System.out.println("2 - Add book to cart");
                System.out.println("0 - Sign out");
                System.out.print("enter: ");
                option = sc.next();

                switch (option) {
                    case "1":
                        System.out.print("choose book: ");
                        chose = sc.next();
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println("Invalid argument!");
                }
            }
        }
    }
}
