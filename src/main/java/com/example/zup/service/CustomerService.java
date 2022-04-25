package com.example.zup.service;

import com.example.zup.model.Customer;
import com.example.zup.model.dto.CustomerPostReqBody;
import com.example.zup.repository.CountryRepository;
import com.example.zup.repository.CountyRepository;
import com.example.zup.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CountryRepository countryRepository;

    private final CountyRepository countyRepository;

    public CustomerService(CustomerRepository customerRepository, CountryRepository countryRepository, CountyRepository countyRepository) {
        this.customerRepository = customerRepository;
        this.countryRepository = countryRepository;
        this.countyRepository = countyRepository;
    }

    public Customer save(CustomerPostReqBody customerPostReqBody){

        Customer customer = Customer.builder()
                .email(customerPostReqBody.getEmail())
                .name(customerPostReqBody.getName())
                .surName(customerPostReqBody.getSurName())
                .document(customerPostReqBody.getDocument())
                .address(customerPostReqBody.getAddress())
                .complement(customerPostReqBody.getComplement())
                .phone(customerPostReqBody.getPhone())
                .cep(customerPostReqBody.getCep())
                .country(countryRepository.findById(customerPostReqBody.getCountryId())
                        .orElseThrow(NullPointerException::new))
                .county(countyRepository.findById(customerPostReqBody.getCountyId())
                        .orElseThrow(NullPointerException::new))
                .build();

        return customerRepository.save(customer);
    }

}
