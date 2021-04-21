package com.example.demo.event;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import org.springframework.context.ApplicationEvent;

public class ClientAddNewFavorite extends ApplicationEvent {
    private User user;
    private Book book;

    public ClientAddNewFavorite(Object source, User user, Book book) {
        super(source);
        this.user = user;
        this.book = book;
    }

    public User getClient() {
        return user;
    }

    public Book getBook() {
        return book;
    }
}
