package com.example.demo.board.entity;

import com.example.demo.comment.CommentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class BoardEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Integer likes;
    @OneToMany(mappedBy = "boardId")
    private List<CommentEntity> comments;

    public BoardEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public BoardEntity() {

    }

    public void __init__(){
        this.likes = 0;
    }
}
