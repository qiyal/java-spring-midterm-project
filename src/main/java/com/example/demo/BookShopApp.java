package com.example.demo;

import com.example.demo.controller.BookController;
import com.example.demo.controller.ClientController;
import com.example.demo.controller.MyOrderController;
import com.example.demo.entity.Book;
import com.example.demo.entity.Client;
import com.example.demo.entity.MyOrder;
import com.example.demo.entity.OrderStatusEnum;
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
    private MyOrderController myOrderController;
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
            System.out.println("Welcome!");
        } else {
            System.out.println("Login or password is not correct!");
        }
    }

    private void singUp() {
        while (true) {
            String login, password, name, surname;
            System.out.print("Login: ");
            login = sc.next();

            if (!clientController.hasClient(login)) {
                System.out.print("Password: ");
                password = sc.next();
                System.out.print("Name: ");
                name = sc.next();
                System.out.print("Surname: " );
                surname = sc.next();

                clientController.saveClient(new Client(login, password, name, surname));
                break;
            } else {
                System.out.println("This Login already exists!");
            }
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
                        singUp();
                        break;
                    case "0":
                        System.out.println("--- EXIT PROGRAM ---");
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
                System.out.println("2 - Add book to favorites");
                System.out.println("3 - Make the order");
                System.out.println("4 - Show cart items");
                System.out.println("5 - Show my favorites");
                System.out.println("0 - Sign out");
                System.out.print("enter: ");
                option = sc.next();

                switch (option) {
                    case "1":
                        System.out.print("choose book: ");
                        chose = sc.next();
                        calculateOrderCost.getCart().addBook(books.get(Integer.parseInt(chose)));
                        break;
                    case "2":
                        System.out.print("choose book: ");
                        chose = sc.next();
                        clientController.addBookToFavorites(clientLogin, books.get(Integer.parseInt(chose)));
                        break;
                    case "3":
                        Client client = clientController.getClient(clientLogin);
                        Integer cost = calculateOrderCost.calculateCost();
                        MyOrder order = new MyOrder(cost, clientLogin, OrderStatusEnum.IN_PROCESSING.toString());
                        myOrderController.saveOrder(order);
                    case "0":
                        isClient = false;
                        authStatus = false;
                        clientLogin = null;
                        break;
                    default:
                        System.out.println("Invalid argument!");
                }
            }
        }
    }
}
