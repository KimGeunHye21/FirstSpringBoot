package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class CoffeeForm {
    Long id;
    String name;
    String price;

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }


}
