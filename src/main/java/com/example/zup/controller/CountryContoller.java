package com.example.zup.controller;

import com.example.zup.model.Country;
import com.example.zup.model.County;
import com.example.zup.model.dto.CountryPostReqBody;
import com.example.zup.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CountryContoller {

    private final CountryService countryService;

    public CountryContoller(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping("country/new")
    @PostMapping
    private ResponseEntity<Country> save(@RequestBody @Valid CountryPostReqBody countryPostReqBody){
       return new ResponseEntity<>(countryService.save(countryPostReqBody), HttpStatus.CREATED);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @RequestMapping("countries")
    public List<Country> listAll(){
        return countryService.listAll();
    }
}
