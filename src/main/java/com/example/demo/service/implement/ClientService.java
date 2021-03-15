package com.example.demo.service.implement;

import com.example.demo.entity.Book;
import com.example.demo.entity.Client;
import com.example.demo.event.ClientAddNewFavorite;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;

@Service
public class ClientService implements IClientService, ApplicationEventPublisherAware {
    @Autowired
    private ClientRepository clientRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public boolean checkClient(String login, String password) {
        Client client = clientRepository.getClientByLoginAndPassword(login, password);

        return (client != null);
    }

    @Override
    public boolean hasLogin(String login) {
        Client client = clientRepository.getClientByLogin(login);

        return (client != null);
    }

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client getClient(String login) {
        return clientRepository.getClientByLogin(login);
    }

    @Override
    public void updateClientFavorites(String login, Book book) {
        boolean status = clientRepository.existsClientByLoginAndBooksContains(login, book);

        if (!status) {
            Client client = clientRepository.getClientByLogin(login);
            client.getBooks().add(book);
            clientRepository.save(client);
            eventPublisher.publishEvent(new ClientAddNewFavorite(this, client, book));
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
