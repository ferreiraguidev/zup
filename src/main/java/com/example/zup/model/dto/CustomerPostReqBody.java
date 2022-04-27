package com.example.zup.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerPostReqBody {

    private String email;
    private String name;
    private String surName;
    private String document;
    private String address;
    private String complement;
    private String cep;
    private String phone;

    private Long countryId;
    private Long countyId;
}
