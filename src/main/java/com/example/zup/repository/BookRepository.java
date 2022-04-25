package com.example.zup.repository;

import com.example.zup.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT  b.lsbn, b.pagesQt, b.price, b.publishDate, b.resumo, b.sumary, b.title\n" +
            "FROM Book b WHERE b.id =  :id ")
    Book listPage(@Param("id")Long id);
    // refactor with dto || builder *
}
