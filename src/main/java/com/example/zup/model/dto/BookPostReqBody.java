package com.example.zup.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class BookPostReqBody {

    @NotBlank
    @Column(unique = true)
    private String title;

    @NotBlank
    @Column(length = 500)
    private String resumo;

    @Column// maskdown format *
    private String sumary;

    @NotNull
    private Integer price;

    private Long pagesQt;

    @Column(unique = true)
    private String lsbn;

    // need to be in the future
    private Date publishDate;

    private Long autorId;

    private Long categoryId;


}
