package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User createNew(User user);
    User updateUsername(Long id, String username);
    User addBookToFavorites(Long userId, Book book);
    User deleteBookFromFavorites(Long userId, Book book);
}
