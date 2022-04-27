package com.example.zup.util;


import com.example.zup.model.dto.AutorPostReqBody;

public class AutorPostReqBodyCreator {

    public static AutorPostReqBody createAutorPostReqBody(){
        return AutorPostReqBody.builder()
                .name("name example")
                .email("gfamorim@hotmail.com")
                .description("description example | test in postman")
                .build();
    }
}
