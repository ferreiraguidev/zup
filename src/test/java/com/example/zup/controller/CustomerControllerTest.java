package com.example.zup.controller;

import com.example.zup.model.Customer;
import com.example.zup.service.CustomerService;
import com.example.zup.util.CustomerCreator;
import com.example.zup.util.CustomerPostReqBodyCreator;
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
class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;
    @Mock
    private CustomerService customerService;

    @Test
    @DisplayName("Saving a Customer")
    void save_When_Successfull(){

        var customerPostReqBody = CustomerPostReqBodyCreator.createCustomerPostReqBody();
        var expectedCustomer = CustomerCreator.createValidCustomer();

        when(customerService.save(customerPostReqBody))
                .thenReturn(expectedCustomer);

        ResponseEntity<Customer> responseEntitySavedCustomer = customerController.save(customerPostReqBody);

        var resultCustomer = responseEntitySavedCustomer.getBody();
        assertAll(
                ()-> assertEquals(CREATED, responseEntitySavedCustomer.getStatusCode()),
                ()-> assertEquals(expectedCustomer, resultCustomer));
    }
}
