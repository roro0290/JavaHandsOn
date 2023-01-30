package com.example.javaHandsOn.springBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    @Autowired
    CurrencyServiceConfiguration config;

    @RequestMapping("/currency-conversion")
    public CurrencyServiceConfiguration convertCurrency(){
        return config;
    }
}
