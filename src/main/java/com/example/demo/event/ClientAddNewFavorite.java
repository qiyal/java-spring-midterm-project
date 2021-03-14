package com.example.demo.event;

import com.example.demo.entity.Book;
import com.example.demo.entity.Client;
import org.springframework.context.ApplicationEvent;

public class ClientAddNewFavorite extends ApplicationEvent {
    private Client client;
    private Book book;

    public ClientAddNewFavorite(Object source, Client client, Book book) {
        super(source);
        this.client = client;
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public Book getBook() {
        return book;
    }
}
