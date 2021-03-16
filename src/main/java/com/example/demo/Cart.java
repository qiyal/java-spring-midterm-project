package com.example.demo;

import com.example.demo.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Cart {
    private ArrayList<Book> list;
    private int cost;

    public Cart() {
        this.list = new ArrayList<>();
        this.cost = 0;
    }

    public void addBook(Book book) {
        System.out.println("Add book:" + book);
        cost += book.getPrice();
        list.add(book);
    }

    public void remove(int index) {
        cost -= list.get(index).getPrice();
        list.remove(index);
    }

    public int getCost() {
        return cost;
    }

    public ArrayList<Book> getList() {
        return list;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
