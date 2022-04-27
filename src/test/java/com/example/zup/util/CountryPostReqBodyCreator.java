package com.example.zup.util;


import com.example.zup.model.dto.CountryPostReqBody;

public class CountryPostReqBodyCreator {

    public static CountryPostReqBody createCountryPostReqBody(){
        return CountryPostReqBody.builder()
                .name("asdokaopdokap")
                .build();
    }
}
