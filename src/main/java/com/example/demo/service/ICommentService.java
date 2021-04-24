package com.example.demo.service;

import com.example.demo.entity.Comment;

import java.util.List;

public interface ICommentService {
    Comment createNew(Comment comment);
    Comment updateComment(Comment comment);
    void deleteCommentById(Long id);
    List<Comment> getCommentsByBookId(Long bookId);
}
