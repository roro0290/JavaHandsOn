package com.example.javaHandsOn.springBoot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// currency-service-url:
// currency-service-username:
// currency-service-password:
@ConfigurationProperties(prefix = "currency-service")
@Data
@Component // SPRING TO MANAGE THIS
public class CurrencyServiceConfiguration {
    // WHAT ARE THE PROPERTIES that we want?
    private String url;
    private String username;
    private String password;
}
