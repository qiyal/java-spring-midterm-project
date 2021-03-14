package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client getClientByLoginAndPassword(String login, String password);
    Client getClientByLogin(String login);
    boolean existsClientByLoginAndBooksContains(String login, Book book);
}
