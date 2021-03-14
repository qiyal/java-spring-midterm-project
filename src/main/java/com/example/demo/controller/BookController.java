package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Client;
import com.example.demo.service.implement.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    public ArrayList<Book> getAllBooks() {
        return (ArrayList<Book>) bookService.getAllBooks();
    }

    public ArrayList<Book> getBookByClientFavorites(Client client) {
        return (ArrayList<Book>) bookService.getBookByClientFavorites(client);
    }
}
