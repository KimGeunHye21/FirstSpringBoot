package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class ArticleForm {
    Long id;
    String title;
    String content;

    /*
    public ArticleForm(String title, String content) {
        System.out.println("id=null start");
        this.id=null;
        this.title=title;
        this.content=content;
        System.out.println("id=null done");
    }


    public ArticleForm(Long id, String title, String content) {
        System.out.println("id=id start");
        this.id=id;
        this.title=title;
        this.content=content;
        System.out.println("id=id done");
    }
    */

    //db로 글을 입력해야됨
    public Article toEntity() {
        return new Article(id, title, content);
    }
}

