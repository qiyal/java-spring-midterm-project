package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getAllBy();
    List<Book> getBooksByClientIsContaining (Client client);
}
