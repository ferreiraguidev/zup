package com.example.zup.util;

import com.example.zup.model.Country;
import com.example.zup.model.County;
import com.example.zup.model.Customer;

import java.util.List;

public class CustomerCreator {

    public static Customer createValidCustomer() {
        return Customer.builder()
                .id(1L)
                .name("Guilherme")
                .surName("asdadas")
                .email("asaa@hotmail.com")
                .address("asdasdasd")
                .cep("61651651a")
                .complement("asdasdasda")
                .phone("1561651651")
                .country(Country.builder().id(1L).build())
                .county(County.builder().id(1L).build())
                .build();
    }
}
