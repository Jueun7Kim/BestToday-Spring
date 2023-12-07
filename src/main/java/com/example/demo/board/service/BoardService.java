package com.example.demo.board.service;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.board.dto.GetAllBoardDto;
import com.example.demo.board.dto.GetBoardDto;
import com.example.demo.board.dto.GetCommentDto;
import com.example.demo.board.dto.PostDto;
import com.example.demo.comment.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Long postBoard(PostDto postDto) {
        BoardEntity board = new BoardEntity(postDto.getTitle(), postDto.getContent());
        board.__init__();
        BoardEntity boardEntity = boardRepository.save(board);

        return boardEntity.getId();
    }

    public GetBoardDto getBoard(Long id) {
        BoardEntity board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        List<GetCommentDto> commentDtos = new ArrayList<>();

        for (int i = 0; i < board.getComments().size(); i++) {
            commentDtos.add(new GetCommentDto(board.getComments().get(i).getBoardId().getId(), board.getComments().get(i).getContent()));
        }

        GetBoardDto postDto = new GetBoardDto(board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getLikes(),
                commentDtos
                );

        return postDto;
    }


    public List<GetAllBoardDto> getBoardAll(){
        return boardRepository.findAll()
                .stream().map(board -> new GetAllBoardDto(
                        board.getId(),
                        board.getTitle(),
                        board.getContent()
                )).toList();
    }

    public void putBoard(Long id, PostDto putData){
        BoardEntity board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        board.setTitle(putData.getTitle());
        board.setContent(putData.getContent());

        boardRepository.save(board);
    }

    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }

    public void likeBoard(Long id){
        BoardEntity Board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        int likes = Board.getLikes();

        Board.setLikes(++likes);

        boardRepository.save(Board);
    }

    public void deleteLikeBoard(Long id){
        BoardEntity Board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        int likes = Board.getLikes();

        Board.setLikes(--likes);

        boardRepository.save(Board);
    }
}
