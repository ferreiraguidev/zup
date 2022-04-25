package com.example.zup.controller;

import com.example.zup.model.County;
import com.example.zup.model.dto.CountyPostReqBody;
import com.example.zup.service.CountyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
public class CountyController {

    private final CountyService countyService;

    public CountyController(CountyService countyService) {
        this.countyService = countyService;
    }

    @PostMapping
    @RequestMapping("county/new")
    private ResponseEntity<County> save(@RequestBody @Valid CountyPostReqBody countyPostReqBody){
        return new ResponseEntity<>(countyService.save(countyPostReqBody), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @RequestMapping("counties")
    public List<County> listAll(){
        return countyService.listAll();
    }
}
