package com.example.javaHandsOn.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {

    // Since we want to map values from Customer to CustomerDto
    // argument will be Customer object
    // return will be CustomerDto
    @Mapping(target = "customerId", source = "id")
    // to provide custom date format
    @Mapping(target = "dateOfBirth", dateFormat = "dd.MM.yyyy")
    CustomerDto customerToDto(Customer customer);
}
