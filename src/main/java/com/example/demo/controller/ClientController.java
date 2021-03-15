package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Client;
import com.example.demo.service.implement.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    public boolean hasClient(String login, String password) {
        return clientService.checkClient(login, password);
    }

    public boolean hasClient(String login) {
        return clientService.hasLogin(login);
    }

    public void saveClient(Client client) {
        clientService.createClient(client);
    }

    public void addBookToFavorites(String login, Book book) {
        clientService.updateClientFavorites(login, book);
    }

    public Client getClient(String login) {
        return clientService.getClient(login);
    }
}
