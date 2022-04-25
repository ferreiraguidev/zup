package com.example.zup.controller;

import com.example.zup.model.Customer;
import com.example.zup.model.dto.CustomerPostReqBody;
import com.example.zup.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @RequestMapping("customer/new")
    @PostMapping
    private ResponseEntity<Customer>save(@RequestBody @Valid CustomerPostReqBody customerPostReqBody){
        return new ResponseEntity<>(customerService.save(customerPostReqBody),CREATED);
    }
}
