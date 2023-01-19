package com.example.javaHandsOn.mapStruct;

import lombok.Data;

@Data
public class CustomerDto {
    private long customerId;
    private String name;
    private String title;
    private String dateOfBirth;
    private Double creditScore;
}
