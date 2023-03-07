package com.example.javaHandsOn.springCloudConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Value("${client.env}")
    String environment;

    public String getEnvironment(){
        return "This environment is: "+environment;
    }
}
