package com.example.zup.service;

import com.example.zup.model.Autor;
import com.example.zup.model.dto.AutorPostReqBody;
import com.example.zup.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor save(AutorPostReqBody autorPostReqBody) {

        Autor autor = Autor.builder()
                .name(autorPostReqBody.getName())
                .email(autorPostReqBody.getEmail())
                .instant(autorPostReqBody.getInstant())
                .description(autorPostReqBody.getDescription())
                .build();
        return autorRepository.save(autor);
    }

    public Autor findById(Long id){
       return autorRepository.findById(id)
               .orElseThrow();

    }
}
