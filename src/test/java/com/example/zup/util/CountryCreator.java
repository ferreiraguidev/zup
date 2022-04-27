package com.example.zup.util;

import com.example.zup.model.Country;
import com.example.zup.model.County;

import java.util.List;

public class CountryCreator {

    public static Country createValidCountry() {
        return Country.builder()
                .id(1L)
                .name("Guilherme")
                .counties(List.of(County.builder().build()))
                .build();
    }
}
