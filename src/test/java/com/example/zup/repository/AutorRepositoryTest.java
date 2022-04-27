package com.example.zup.repository;

import com.example.zup.model.Autor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class AutorRepositoryTest {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    void saveAutor_WhenSuccessful(){

        Autor autorToBeSaved = createAutor();
        Autor savedAutor = autorRepository.save(autorToBeSaved);

        Assertions.assertThat(savedAutor).isNotNull();
        Assertions.assertThat(savedAutor.getId()).isNotNull();
        Assertions.assertThat(!(savedAutor.getEmail().isBlank()));
        Assertions.assertThat(savedAutor.getEmail().repeat(1)); // unique = true *
        Assertions.assertThat(!(savedAutor.getName().isBlank()));
//        Assertions.assertThat(!(savedAutor.getInstant().isAfter(savedAutor.getInstant())));
        Assertions.assertThat(!(savedAutor.getDescription().length() > 400));


    }
    private Autor createAutor(){
        return Autor.builder()
                .name("example")
                .email("example@gmail.com")
//                .instant(2019-02-12T11:49:22.455Z) could not find a fucking one but works on postman *
                .description("ANYTHING YOUD LIKE TO WRITE")
                .build();
    }

}