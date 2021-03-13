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
        cost += book.getPrice();
        list.add(book);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public int getCost() {
        return cost;
    }

}
