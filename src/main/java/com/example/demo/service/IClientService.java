package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Client;

public interface IClientService {
    boolean checkClient(String login, String password);
    boolean hasLogin(String login);
    void createClient(Client client);
    Client getClient(String login);
    void updateClientFavorites(String login, Book book);
}
