package com.example.zup.util;

import com.example.zup.model.Country;
import com.example.zup.model.County;

public class CountyCreator {

    public static County createValiCat() {
        return County.builder()
                .name("Limerick or Bundoran")
                .country(Country.builder().id(1L).build())
                .build();
    }
}
