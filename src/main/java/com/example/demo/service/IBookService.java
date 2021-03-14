package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Client;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    List<Book> getBookByClientFavorites(Client client);
}
