package com.example.zup.util;


import com.example.zup.model.dto.CountyPostReqBody;

public class CountyPostReqBodyCreator {

    public static CountyPostReqBody createCountyPostReqBody(){
        return CountyPostReqBody.builder()
                .name("asdokaopdokap")
                .countryNameId(1L)
                .build();
    }
}
