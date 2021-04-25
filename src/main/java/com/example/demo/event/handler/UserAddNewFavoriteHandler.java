package com.example.demo.event.handler;

import com.example.demo.event.UserAddNewFavorite;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserAddNewFavoriteHandler implements ApplicationListener<UserAddNewFavorite> {
    @Override
    public void onApplicationEvent(UserAddNewFavorite userAddNewFavorite) {
        System.out.println("UserAddNewFavoriteHandler is triggered");
        System.out.println("User: " + userAddNewFavorite.getUser().getUsername());
        System.out.println("Book: " + userAddNewFavorite.getBook().getName());
    }
}
