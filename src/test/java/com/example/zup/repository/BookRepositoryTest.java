package com.example.zup.repository;

import com.example.zup.model.Autor;
import com.example.zup.model.Book;
import com.example.zup.model.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void saveBook(){
        Book bookToBeSaved = createBook();
        Book savedBook = bookRepository.save(bookToBeSaved);

        Assertions.assertThat(savedBook).isNotNull();
        Assertions.assertThat(savedBook.getId()).isNotNull();
        Assertions.assertThat(savedBook.getTitle()).isNotNull();
        Assertions.assertThat(!(savedBook.getTitle()).isEmpty());
        Assertions.assertThat(!(savedBook.getResumo()).isEmpty());
        Assertions.assertThat(savedBook.getResumo()).isNotNull();
        Assertions.assertThat(!(savedBook.getResumo().length() > 500));
        Assertions.assertThat(!(savedBook.getResumo().length() > 255));
        Assertions.assertThat(savedBook.getPrice()).isNotNull();
        //lsbn unique= true *
        Assertions.assertThat(savedBook.getAutor()).isNotNull();
        Assertions.assertThat(savedBook.getCategory()).isNotNull();
        Assertions.assertThat(savedBook.getPublishDate().after(new Date()));

    }

    private Book createBook() {
        return Book.builder()
                .title("title")
                .sumary("asdasdasda")
                .resumo("asdsadsad")
                .lsbn("54asd45as45d")
                .price(1500)
                .pagesQt(5650L)
                .publishDate(new Date())
                .autor(Autor.builder().id(1L).build())
                .category(Category.builder().id(1L).build())
                .build();
    }

}