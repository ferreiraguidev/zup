package com.example.zup.util;


import com.example.zup.model.dto.CustomerPostReqBody;

public class CustomerPostReqBodyCreator {

    public static CustomerPostReqBody createCustomerPostReqBody(){
        return CustomerPostReqBody.builder()
                .name("name prenom")
                .surName("surname nomDeFamille")
                .email("gfamorim@hotmail.com")
                .address("rua c 102 sadsad")
                .cep("74005")
                .complement("complement square streeet flow")
                .phone("198185196")
                .document("doc")
                .countyId(1L)
                .countryId(1L)
                .build();
    }
}
