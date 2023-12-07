package com.example.demo.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllBoardDto {
    private Long id;
    private String title;
    private String content;
}
