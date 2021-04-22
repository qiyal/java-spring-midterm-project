package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService iUserService;

    // GET
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(iUserService.getAll());
    }

    // POST
    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        return ResponseEntity.ok(iUserService.createNew(user));
    }

    // PATCH
    @PatchMapping("/{id}/update/password")
    public ResponseEntity<?> updateUserPassword(@PathVariable("id") Long id, @RequestBody String password) {
        return ResponseEntity.ok(iUserService.updateUsername(id, password));
    }

    @PatchMapping("/{id}/update/add-book-to-favorites")
    public ResponseEntity<?> addBookToFavorites(@PathVariable("id") Long id, @RequestBody Book book) {
        return ResponseEntity.ok(iUserService.addBookToFavorites(id, book));
    }
}
