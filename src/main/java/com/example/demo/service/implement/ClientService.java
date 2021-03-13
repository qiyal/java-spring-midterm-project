package com.example.demo.service.implement;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public boolean checkClient(String login, String password) {
        Client client = clientRepository.getClientByLoginAndPassword(login, password);

        return (client != null);
    }
}
