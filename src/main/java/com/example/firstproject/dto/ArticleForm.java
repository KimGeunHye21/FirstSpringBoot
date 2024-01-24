package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ArticleForm {
    Long id;
    String title;
    String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}

