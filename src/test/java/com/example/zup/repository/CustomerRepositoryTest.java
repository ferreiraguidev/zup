package com.example.zup.repository;

import com.example.zup.model.Country;
import com.example.zup.model.County;
import com.example.zup.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("save Customer")
    void saveCustomer_WhenSuccessful(){
        Customer customerToBeSaved = createCustomer();
        Customer savedCustomer = customerRepository.save(customerToBeSaved);

        Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer.getId()).isNotNull();
        Assertions.assertThat(savedCustomer.getName()).isNotNull();
        Assertions.assertThat(!(savedCustomer.getName()).isBlank());
        Assertions.assertThat(savedCustomer.getSurName()).isNotNull();
        Assertions.assertThat(!(savedCustomer.getSurName()).isBlank());
      // EMAIL UNIQUE = TRUE
        Assertions.assertThat(!(savedCustomer.getDocument()).isBlank());
        Assertions.assertThat(!(savedCustomer.getAddress()).isBlank());
        Assertions.assertThat(!(savedCustomer.getComplement()).isBlank());
        Assertions.assertThat(!(savedCustomer.getCep()).isBlank());
        Assertions.assertThat(!(savedCustomer.getPhone()).isBlank());


    }
    private Customer createCustomer(){
        return Customer.builder()
                .name("testing name")
                .surName("surname")
                .email("gfamorim@hotmail.com")
                .address("limerick streeet avenue or rue de la gare du nord")
                .cep("74000")
                .complement("cross the square")
                .phone("8494984984")
                .document("asdas65")
                .county(County.builder().id(1L).build())
                .country(Country.builder().id(1L).build())
                .build();
    }

}