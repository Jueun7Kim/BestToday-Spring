package com.example.demo.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentRepository CommentRepository;

    @Autowired
    private CommentService CommentService;

    @PostMapping
    public Long postComment(@RequestBody CommentDto CommentDto){
        return CommentService.postComment(CommentDto);
    }
}