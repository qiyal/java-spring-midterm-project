package com.example.demo.controller;

import com.example.demo.service.implement.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    public boolean hasClient(String login, String password) {
        return clientService.checkClient(login, password);
    }
}
