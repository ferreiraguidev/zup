package com.example.zup.util;

import com.example.zup.model.Autor;

public class AutorCreator {

    public static Autor createValidAutor() {
        return Autor.builder()
                .id(1L)
                .name("Capitão areia")
                .email("gfamorim@hotmail.com")
//                .instant(new LocalDateTime())
                .description("description testing...")
                .build();
    }
}
