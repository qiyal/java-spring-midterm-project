package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // DELETE
    @DeleteMapping("/{id}/delete/favoriteBooks")
    public ResponseEntity<?> deleteBookFromFavoriteBook(@PathVariable("id") Long id, @RequestBody Book book) {
        return ResponseEntity.ok(iUserService.deleteBookFromFavorites(id, book));
    }

    // PATCH - 2
    @PatchMapping("/{id}/update/username")
    public ResponseEntity<?> updateUserPassword(@PathVariable("id") Long id, @RequestBody String username) {
        return ResponseEntity.ok(iUserService.updateUsername(id, username));
    }

    @PatchMapping("/{id}/update/add-book-to-favorites")
    public ResponseEntity<?> addBookToFavorites(@PathVariable("id") Long id, @RequestBody Book book) {
        return ResponseEntity.ok(iUserService.addBookToFavorites(id, book));
    }
}
