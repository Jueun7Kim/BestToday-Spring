package com.example.demo.board.controller;

import com.example.demo.board.dto.GetAllBoardDto;
import com.example.demo.board.dto.GetBoardDto;
import com.example.demo.board.dto.PostDto;
import com.example.demo.board.entity.BoardEntity;
import com.example.demo.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // CRUD
    @PostMapping
    public Long postBoard(@RequestBody PostDto postDto) {
        return boardService.postBoard(postDto);
    }

    @GetMapping
    public GetBoardDto getBoard(@RequestParam(name = "id") Long id) {
        return boardService.getBoard(id);
    }

    @GetMapping("/all")
    public List<GetAllBoardDto> getBoards() {
        return boardService.getBoardAll();
    }
    

    @PutMapping
    public void putBoard(@RequestParam(name = "id") Long id, @RequestBody PostDto postDto) {
       boardService.putBoard(id, postDto);
    }

    @DeleteMapping
    public void deleteBoard(@RequestParam(name = "id") Long id) {
        boardService.deleteBoard(id);
    }


    // Like
    @PostMapping("/likes")
    public void likeBoard(@RequestParam(name="id") Long id){
        boardService.likeBoard(id);
    }

    @DeleteMapping("/likes")
    public void deleteLikeBoard(@RequestParam(name="id") Long id){
        boardService.deleteLikeBoard(id);
    }
}
