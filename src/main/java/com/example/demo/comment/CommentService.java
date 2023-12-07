package com.example.demo.comment;

import com.example.demo.board.entity.BoardEntity;
import com.example.demo.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository CommentRepository;

    @Autowired
    private BoardRepository boardRepository;

    public Long postComment(CommentDto CommentDto){
        BoardEntity boardEntity = boardRepository.findById(CommentDto.getBoard_id())
                .orElseThrow(() -> new RuntimeException());

        CommentEntity comment = new CommentEntity(boardEntity,CommentDto.getContent());

        CommentEntity CommentEntity = CommentRepository.save(comment);

        return CommentEntity.getId();
    }
}
