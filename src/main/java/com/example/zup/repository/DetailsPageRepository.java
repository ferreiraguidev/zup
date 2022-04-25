package com.example.zup.repository;


import com.example.zup.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsPageRepository extends JpaRepository<Book, Long> {

//    @Query("")
//    List<Book> listPage();

}
