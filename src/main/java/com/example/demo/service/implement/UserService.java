package com.example.demo.service.implement;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUsername(Long id, String username) {
        User user = userRepository.getOne(id);
        user.setUsername(username);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User addBookToFavorites(Long userId, Book book) {
        User user = userRepository.getOne(userId);
        user.getFavoriteBooks().add(book);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User createNew(User user) {
        return userRepository.saveAndFlush(user);
    }
}
