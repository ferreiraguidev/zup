package com.example.zup.controller;

import com.example.zup.model.County;
import com.example.zup.service.CountyService;
import com.example.zup.util.CountyCreator;
import com.example.zup.util.CountyPostReqBodyCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(SpringExtension.class)
class CountyControllerTest {

    @InjectMocks
    CountyController countyController;
    @Mock
    CountyService countyService;

    @Test
    @DisplayName("save county when successful")
    void save_When_Successful(){

        var countyPostReqBody = CountyPostReqBodyCreator.createCountyPostReqBody();
        var expectedCOunty = CountyCreator.createValiCat();

        when(countyService.save(countyPostReqBody))
                .thenReturn(expectedCOunty);

        // RESULT
        ResponseEntity<County> responseEntityCountyCustomer = countyController.save(countyPostReqBody);

        var resultCounty = responseEntityCountyCustomer.getBody();
        assertAll(
                ()-> assertEquals(CREATED, responseEntityCountyCustomer.getStatusCode()),
                ()-> assertEquals(expectedCOunty, resultCounty));
    }
}
