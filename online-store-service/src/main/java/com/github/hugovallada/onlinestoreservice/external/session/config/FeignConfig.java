package com.github.hugovallada.onlinestoreservice.external.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.hugovallada.onlinestoreservice.external.inventory.InventoryServiceClient;
import com.github.hugovallada.onlinestoreservice.external.session.UserSessionClient;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;

@Configuration
public class FeignConfig {

    @Bean
    public UserSessionClient userSessionClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger())
                .target(UserSessionClient.class, "http://localhost:8082");
    }

    @Bean
    public InventoryServiceClient inventoryServiceClient() {
        return Feign.builder()
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder())
        .logLevel(Logger.Level.FULL)
        .logger(new Slf4jLogger())
        .target(InventoryServiceClient.class, "http://localhost:8084");
    }
}
