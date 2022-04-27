package com.example.zup.controller;

import com.example.zup.model.Autor;
import com.example.zup.model.Country;
import com.example.zup.model.dto.AutorPostReqBody;
import com.example.zup.model.dto.CountryPostReqBody;
import com.example.zup.service.AutorService;
import com.example.zup.util.AutorCreator;
import com.example.zup.util.AutorPostReqBodyCreator;
import com.example.zup.util.CountryCreator;
import com.example.zup.util.CountryPostReqBodyCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class AutorControllerTest {

    @InjectMocks
    private AutorController autorController;
    @Mock
    private AutorService autorService;

    @BeforeEach
    void setUp() {
        when(autorService.save(ArgumentMatchers.any(AutorPostReqBody.class)))
                .thenReturn(AutorCreator.createValidAutor());

    }
    @Test
    @DisplayName("Saving ")
    void save_When_Successful(){
        // composition
        var autorPostReqBody = AutorPostReqBodyCreator.createAutorPostReqBody();

        var expectedAutor = AutorCreator.createValidAutor();
        when(autorService.save(autorPostReqBody))
                .thenReturn(expectedAutor);

        // execution
        ResponseEntity<Autor> responseEntitySavedCountry = autorController.save(autorPostReqBody);

        // result
        var resultCountry = responseEntitySavedCountry.getBody();
        assertAll(
                ()-> assertEquals(HttpStatus.CREATED, responseEntitySavedCountry.getStatusCode()),
                ()-> assertEquals(expectedAutor,resultCountry));
    }
}
