package com.example.demo.handler;

import com.example.demo.event.ClientAddNewFavorite;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ClientAddNewFavoriteHandler implements ApplicationListener<ClientAddNewFavorite> {
    @Override
    public void onApplicationEvent(ClientAddNewFavorite clientAddNewFavorite) {
        System.out.println("ClientAddNewFavoriteHandler is triggered");
        System.out.println("Client: " + clientAddNewFavorite.getClient());
        System.out.println("Book: " + clientAddNewFavorite.getBook().getName());
    }
}
