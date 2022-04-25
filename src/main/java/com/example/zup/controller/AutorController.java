package com.example.zup.controller;

import com.example.zup.model.Autor;
import com.example.zup.model.dto.AutorPostReqBody;
import com.example.zup.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @PostMapping("autor/new")
    public ResponseEntity<Autor> save(@RequestBody @Valid final AutorPostReqBody autorPostReqBody){
        return new ResponseEntity<>(autorService.save(autorPostReqBody),CREATED);
    }
}
