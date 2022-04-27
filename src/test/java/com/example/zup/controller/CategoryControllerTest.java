package com.example.zup.controller;

import com.example.zup.model.Category;
import com.example.zup.service.CategoryService;
import com.example.zup.util.CategoryCreator;
import com.example.zup.util.CategoryPostReqBodyCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CategoryControllerTest {

    @InjectMocks
    CategoryController categoryController;
    @Mock
    private CategoryService categoryService;

    @Test
    @DisplayName("Saving ")
    void save_When_Successful(){
        // composition
        var catPostReqBody = CategoryPostReqBodyCreator.createCategoryPostReqBody();

        var expectedCat = CategoryCreator.createValiCat();
        when(categoryService.save(catPostReqBody))
                .thenReturn(expectedCat);

        // execution
        ResponseEntity<Category> responseEntitySavedBook = categoryController.save(catPostReqBody);

        // result
        var resultBook = responseEntitySavedBook.getBody();
        assertAll(
                ()-> assertEquals(HttpStatus.CREATED, responseEntitySavedBook.getStatusCode()),
                ()-> assertEquals(expectedCat,resultBook));
    }
}