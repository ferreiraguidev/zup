package com.example.zup.service;

import com.example.zup.model.Category;
import com.example.zup.model.dto.CategoryPostReqBody;
import com.example.zup.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(CategoryPostReqBody categoryPostReqBody){
        Category category = Category.builder()
                .name(categoryPostReqBody.getName())
                .build();
        return  categoryRepository.save(category);
    }
}
