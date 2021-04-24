package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private ICommentService iCommentService;

    // GET
    @GetMapping("")
    public ResponseEntity<?> getCommentsByBookId(@RequestParam("bookId") Long bookId) {
        return ResponseEntity.ok(iCommentService.getCommentsByBookId(bookId));
    }

    // POST
    @PostMapping("/create")
    public ResponseEntity<?> createNewComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(iCommentService.createNew(comment));
    }

    // PUT
    @PutMapping("/update")
    public ResponseEntity<?> updateComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(iCommentService.updateComment(comment));
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id") Long id) {
        iCommentService.deleteCommentById(id);
    }
}
