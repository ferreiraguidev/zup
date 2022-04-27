package com.example.zup.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CountryPostReqBody {

    private  String name;

    private Long countyId;
}
