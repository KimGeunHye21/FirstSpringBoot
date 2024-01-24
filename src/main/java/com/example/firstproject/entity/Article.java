package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Article {

    @Getter
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Column
    private String title;

    @Getter
    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null) this.title = article.title;
        if (article.content != null) this.content = article.content;
    }
}
