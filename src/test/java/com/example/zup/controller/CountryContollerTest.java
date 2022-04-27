package com.example.zup.controller;

import com.example.zup.model.Country;
import com.example.zup.model.dto.CountryPostReqBody;
import com.example.zup.service.CountryService;
import com.example.zup.util.CountryCreator;
import com.example.zup.util.CountryPostReqBodyCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CountryContollerTest {

    @InjectMocks
    private CountryContoller countryContoller;
    @Mock
    private CountryService countryServiceMock;

    @BeforeEach
    void setUp() {
        when(countryServiceMock.save(ArgumentMatchers.any(CountryPostReqBody.class)))
                .thenReturn(CountryCreator.createValidCountry());

    }

    @Test
    @DisplayName("Saving ")
    void save_When_Successful(){
        // composition
        var countryPostReqBody = CountryPostReqBodyCreator.createCountryPostReqBody();

        var expectedCountry = CountryCreator.createValidCountry();
        when(countryServiceMock.save(countryPostReqBody))
                .thenReturn(expectedCountry);

        // execution
        ResponseEntity<Country> responseEntitySavedCountry = countryContoller.save(countryPostReqBody);

        // result
        var resultCountry = responseEntitySavedCountry.getBody();
        assertAll(
                ()-> assertEquals(HttpStatus.CREATED, responseEntitySavedCountry.getStatusCode()),
                ()-> assertEquals(expectedCountry,resultCountry));
    }

    @Test
    @DisplayName("List All Countries")
    void listAll(){
        CountryContoller mock = Mockito.mock(CountryContoller.class);
        List<Country> all = mock.listAll();
        assertAll(all::isEmpty);
    }
}