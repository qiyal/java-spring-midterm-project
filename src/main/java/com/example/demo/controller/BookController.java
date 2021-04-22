package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    // GET
    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(iBookService.getAll());
    }

    // POST
    @PostMapping("/create")
    public ResponseEntity<?> createNewBook(@RequestBody Book book) {
        return ResponseEntity.ok(iBookService.createNew(book));
    }

    // PUT
    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(iBookService.update(book));
    }

    // PATCH
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateBookPrice(@PathVariable("id") Long id, @RequestParam("price") Integer price) {
        return ResponseEntity.ok(iBookService.updateBookPrice(id, price));
    }
}
