package com.example.nearbyplaces.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.temporal.Temporal;

@Configuration
public class AppConfig {
    @Bean
   public RestTemplate restTemplate(){
      return new RestTemplate();
   }
}