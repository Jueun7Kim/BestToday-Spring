package com.example.demo.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetBoardDto {
    private Long id;
    private String title;
    private String content;
    private Integer likes;
    private List<GetCommentDto> comments;
}
