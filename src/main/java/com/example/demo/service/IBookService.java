package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    List<Book> findBookByNameOrAuthor(String name, String author);
    Book getBookById(Long id);
    Book createNew(Book book);
    Book update(Book book);
    Book updateBookPrice(Long bookId, Integer price);
    void deleteBookById(Long id);
}
