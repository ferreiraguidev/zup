package com.example.zup.controller;

import com.example.zup.model.Book;
import com.example.zup.model.dto.BookPostReqBody;
import com.example.zup.service.BookService;
import com.example.zup.util.BookCreator;
import com.example.zup.util.BookPostReqBodyCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class BookContollerTest {

    @InjectMocks
    private BookController bookController ;
    @Mock
    private BookService bookService;

    @BeforeEach
    void setUp() {
        when(bookService.save(ArgumentMatchers.any(BookPostReqBody.class)))
                .thenReturn(BookCreator.createValidBook());
    }

    @Test
    @DisplayName("Saving ")
    void save_When_Successful(){
        // composition
        var bookPostReqBody = BookPostReqBodyCreator.createBookPostReqBody();

        var expectedBook = BookCreator.createValidBook();
        when(bookService.save(bookPostReqBody))
                .thenReturn(expectedBook);

        // execution
        ResponseEntity<Book> responseEntitySavedBook = bookController.save(bookPostReqBody);

        // result
        var resultBook = responseEntitySavedBook.getBody();
        assertAll(
                ()-> assertEquals(HttpStatus.CREATED, responseEntitySavedBook.getStatusCode()),
                ()-> assertEquals(expectedBook,resultBook));
    }

    @Test
    @DisplayName("List Certain Attributes of a Book By ID")
    void listCertainById(){

        BookController mock = Mockito.mock(BookController.class);
        Book book = new Book();
        Book aBook = mock.listCertain(book.getId());

        var resultBook = aBook;
        assertAll(
                ()->assertEquals(null,aBook)
        );
    }
}
