package com.example.demo;

import com.example.demo.controller.AdminController;
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

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class BookShopApp {
    @Autowired
    @Qualifier("initScanner")
    private Scanner sc;

    @Autowired
    private AdminController adminController;
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
    private String currentLogin;

    public BookShopApp() {
        this.authStatus = false;
        this.isClient = false;
        this.currentLogin = null;
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
            this.currentLogin = login;
            System.out.println("Welcome!");
        } else if (adminController.checkAdmin(login, password)) {
            this.authStatus = true;
            this.currentLogin = login;
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
                System.out.println("6 - Show my order");
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
                        clientController.addBookToFavorites(currentLogin, books.get(Integer.parseInt(chose)));
                        break;
                    case "3":
                        Client client = clientController.getClient(currentLogin);
                        Integer cost = calculateOrderCost.calculateCost();
                        MyOrder order = new MyOrder(cost, currentLogin, OrderStatusEnum.IN_PROCESSING.toString());
                        myOrderController.saveOrder(order);
                        break;
                    case "4":
                        ArrayList<Book> items = calculateOrderCost.getCart().getList();
                        for (int i = 0; i < items.size(); i++) {
                            System.out.println(i + ") " + items.get(i).getName() + " Price: " + items.get(i).getPrice());
                        }
                        System.out.println("Total amount: " + calculateOrderCost.getCart().getCost());
                        break;
                    case "5":
                        System.out.println("My favorites list");
                        Set<Book> list = clientController.getClient(currentLogin).getBooks();

                        int q = 0;
                        for (Book book : list) {
                            System.out.println(q + ") " + book.getName() + "\t" + "Price: " + book.getPrice());
                        }
                        break;
                    case "6":
                        System.out.println("My orders");
                        ArrayList<Order> orders = clientController.getClientOrders(currentLogin);
                    case "0":
                        isClient = false;
                        authStatus = false;
                        currentLogin = null;
                        break;
                    default:
                        System.out.println("Invalid argument!");
                }
            } else if (authStatus) {
                ArrayList<MyOrder> orders = myOrderController.getByStatusNot(OrderStatusEnum.PAID.toString());

                for (int i = 0; i < orders.size(); i++) {
                    System.out.println(i + ") " + "Client login: " + orders.get(i).getClientLogin());
                    System.out.println("   Cost: " + orders.get(i).getCost());
                    System.out.println("   Status: " + orders.get(i).getStatus());
                }
                System.out.println("1 - Change status of order");
                System.out.println("0 - Sign out");
                System.out.print("enter: ");
                option = sc.next();

                switch (option) {
                    case "1":
                        System.out.print("choose order: ");
                        chose = sc.next();

                        System.out.println("1 - " + OrderStatusEnum.EXPECT_DELIVERY);
                        System.out.println("2 - " + OrderStatusEnum.PAID);
                        System.out.print("enter: ");
                        option = sc.next();

                        String newStatus;
                        if (option.equals("1")) {
                            newStatus = OrderStatusEnum.EXPECT_DELIVERY.toString();
                        } else {
                            newStatus = OrderStatusEnum.PAID.toString();
                        }

                        myOrderController.updateOrderStatus(orders.get(Integer.parseInt(chose)), newStatus, currentLogin);
                        break;
                    case "0":
                        authStatus = false;
                        currentLogin = null;
                        break;
                    default:
                        System.out.println("def");
                }
            }
        }
    }
}
