package com.example.zup.util;


import com.example.zup.model.dto.CategoryPostReqBody;

public class CategoryPostReqBodyCreator {

    public static CategoryPostReqBody createCategoryPostReqBody() {
        return CategoryPostReqBody.builder()
                .name("test")
                .build();
    }
}
