package com.example.zup.service;

import com.example.zup.model.County;
import com.example.zup.model.dto.CountyPostReqBody;
import com.example.zup.repository.CountryRepository;
import com.example.zup.repository.CountyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {

    private final CountyRepository countyRepository;
    private final CountryRepository countryRepository;

    public CountyService(CountyRepository countyRepository, CountryRepository countryRepository) {
        this.countyRepository = countyRepository;
        this.countryRepository = countryRepository;
    }

    public County save(CountyPostReqBody countyPostReqBody){

        County county = County.builder()
                .name(countyPostReqBody.getName())
                .country(countryRepository.findById(countyPostReqBody.getCountryNameId())
                .orElseThrow(RuntimeException::new))
                .build();

        return countyRepository.save(county);
    }

    public List<County> listAll(){
        return countyRepository.findAll();
    }
}
