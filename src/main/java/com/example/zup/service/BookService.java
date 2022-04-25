package com.example.zup.service;

import com.example.zup.model.Book;
import com.example.zup.model.dto.BookPostReqBody;
import com.example.zup.repository.AutorRepository;
import com.example.zup.repository.BookRepository;
import com.example.zup.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepositor;

    private final CategoryRepository categoryRepository;

    private final AutorRepository autorRepository;

    public BookService(BookRepository bookRepositor, CategoryRepository categoryRepository, AutorRepository autorRepository) {
        this.bookRepositor = bookRepositor;
        this.categoryRepository = categoryRepository;
        this.autorRepository = autorRepository;
    }

    public Book save(BookPostReqBody bookPostReqBody){
        Book book = Book.builder()
                .resumo(bookPostReqBody.getResumo())
                .publishDate(bookPostReqBody.getPublishDate())
                .title(bookPostReqBody.getTitle())
                .sumary(bookPostReqBody.getSumary())
                .price(bookPostReqBody.getPrice())
                .pagesQt(bookPostReqBody.getPagesQt())
                .lsbn(bookPostReqBody.getLsbn())
                .autor(autorRepository.findById(bookPostReqBody.getAutorId())
                        .orElseThrow(NullPointerException::new))
                //TODO  i'll use autorService
                .category(categoryRepository.findById(bookPostReqBody.getCategoryId())
                        .orElseThrow(NullPointerException::new))
                .build();

        return bookRepositor.save(book);
    }

    public Book findById(Long id){
        Book book = bookRepositor.findById(id)
                .orElseThrow(NullPointerException::new);
        return Book.builder()
                .title(book.getTitle())
                .price(book.getPrice())
                .sumary(book.getSumary())
                .autor(book.getAutor())
                .pagesQt(book.getPagesQt())
                .lsbn(book.getLsbn())
                .publishDate(book.getPublishDate())
                .category(book.getCategory())
                .build();
    }
}
