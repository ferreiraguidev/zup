package com.example.zup.util;

import com.example.zup.model.Category;

public class CategoryCreator {

    public static Category createValiCat() {
        return Category.builder()
                .name("fiction action whatever programming")
                .build();
    }
}
