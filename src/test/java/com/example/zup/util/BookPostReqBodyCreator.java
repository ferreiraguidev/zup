package com.example.zup.util;


import com.example.zup.model.dto.BookPostReqBody;

import java.util.Date;

public class BookPostReqBodyCreator {

    public static BookPostReqBody createBookPostReqBody() {
        return BookPostReqBody.builder()
                .title("title")
                .sumary("sumary")
                .lsbn("askdopa789")
                .pagesQt(500L)
                .price(1500)
                .resumo("resume too blessed")
                .publishDate(new Date())
                .autorId(1L)
                .categoryId(1L)
                .build();
    }
}
