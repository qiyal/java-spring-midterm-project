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

    // GET - 3
    @GetMapping("")
    public ResponseEntity<?> findBookByNameOrAuthor(@RequestParam("name") String name, @RequestParam("author") String author) {
        return ResponseEntity.ok(iBookService.findBookByNameOrAuthor(name, author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable() Long id) {
        return ResponseEntity.ok(iBookService.getBookById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(iBookService.getAll());
    }

    // POST
    @PostMapping("/action/create")
    public ResponseEntity<?> createNewBook(@RequestBody Book book) {
        return ResponseEntity.ok(iBookService.createNew(book));
    }

    // PUT
    @PutMapping("/action/update")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(iBookService.update(book));
    }

    // DELETE
    @DeleteMapping("/action/delete/{id}")
    public void deleteBookById(@PathVariable("id") Long id) {
        iBookService.deleteBookById(id);
    }

    // PATCH
    @PatchMapping("/action/update/{id}")
    public ResponseEntity<?> updateBookPrice(@PathVariable("id") Long id, @RequestParam("price") Integer price) {
        return ResponseEntity.ok(iBookService.updateBookPrice(id, price));
    }
}
