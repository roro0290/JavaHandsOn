package com.example.javaHandsOn.mapStruct;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private String title;
    private LocalDate dateOfBirth;
    private BigDecimal creditScore;
}
