package com.example.zup.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String title;

    @NotBlank
    @Column(length = 500)
    private String resumo;

    @Column
    private String sumary;

    @NotNull
    private Integer price;

    private Long pagesQt;

    @Column(unique = true)
    private String lsbn;

    @Future
    private Date publishDate;

    @NotNull
    @OneToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @NotNull
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
