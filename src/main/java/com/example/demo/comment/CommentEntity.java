package com.example.demo.comment;

import com.example.demo.board.entity.BoardEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommentEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private BoardEntity boardId;

    public CommentEntity(BoardEntity board_id, String content){
        this.boardId = board_id;
        this.content = content;
    }

    public CommentEntity() {

    }
}
