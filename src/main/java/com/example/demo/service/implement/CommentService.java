package com.example.demo.service.implement;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createNew(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getCommentsByBookId(Long bookId) {
        return commentRepository.getCommentsByBookId(bookId);
    }
}
