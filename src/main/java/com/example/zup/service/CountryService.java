package com.example.zup.service;

import com.example.zup.model.Country;
import com.example.zup.model.County;
import com.example.zup.model.dto.CountryPostReqBody;
import com.example.zup.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country save(CountryPostReqBody countryPostReqBody){

        Country country = Country.builder()
                .name(countryPostReqBody.getName())
                .build();
        return countryRepository.save(country);
    }
    public List<Country> listAll(){
        return countryRepository.findAll();
    }
}
