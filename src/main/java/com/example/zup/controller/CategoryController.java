package com.example.zup.controller;

import com.example.zup.model.Category;
import com.example.zup.model.dto.CategoryPostReqBody;
import com.example.zup.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ResponseStatus(CREATED)
    @PostMapping("category/new")
    public ResponseEntity<Category> save(@RequestBody @Valid final CategoryPostReqBody categoryPostReqBody){
        return new ResponseEntity<>(categoryService.save(categoryPostReqBody), CREATED);
    }
}
