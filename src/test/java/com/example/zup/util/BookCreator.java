package com.example.zup.util;

import com.example.zup.model.Autor;
import com.example.zup.model.Book;
import com.example.zup.model.Category;

import java.util.Date;

public class BookCreator {

    public static Book createValidBook() {
        return Book.builder()
                .id(1L)
                .lsbn("book identifier")
                .publishDate(new Date())
                .sumary("sumary")
                .price(15000)
                .pagesQt(389L)
                .title("Capitão Areia")
                .autor(Autor.builder().id(1L).build())
                .category(Category.builder().id(1L).build())
                .build();
    }
}
