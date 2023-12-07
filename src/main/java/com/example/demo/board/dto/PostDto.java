package com.example.demo.board.dto;

import com.example.demo.comment.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;
}
