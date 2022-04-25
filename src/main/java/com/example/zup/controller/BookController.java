package com.example.zup.controller;

import com.example.zup.model.Book;
import com.example.zup.model.dto.BookPostReqBody;
import com.example.zup.repository.BookRepository;
import com.example.zup.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("book/new")
    private ResponseEntity<Book> save(@RequestBody @Valid BookPostReqBody bookPostReqBody){
        return new ResponseEntity<>(bookService.save(bookPostReqBody), HttpStatus.CREATED);
    }

    @GetMapping("books/{id}")
    public Book listCertain(@PathVariable Long id){
        return bookService.findById(id);
    }
}
