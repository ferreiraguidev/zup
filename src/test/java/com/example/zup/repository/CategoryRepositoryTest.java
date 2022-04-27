package com.example.zup.repository;

import com.example.zup.model.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @DisplayName("Save Category")
    void save_Category_WhenSuccessful(){

        Category catToBeSaved = createCat();
        Category savedCat = categoryRepository.save(catToBeSaved);

        Assertions.assertThat(savedCat.getId()).isNotNull();
        Assertions.assertThat(savedCat.getName()).isNotNull();
        Assertions.assertThat(!(savedCat.getName()).isBlank());
    }


    private Category createCat(){
        return Category.builder()
                .name("example of cat getting better")
                .build();
    }

}