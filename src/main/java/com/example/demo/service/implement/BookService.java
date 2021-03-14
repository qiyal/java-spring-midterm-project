package com.example.demo.service.implement;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBy();
    }
}
