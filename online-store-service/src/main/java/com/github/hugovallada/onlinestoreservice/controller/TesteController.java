package com.github.hugovallada.onlinestoreservice.controller;

import java.sql.SQLException;

import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping
    @Retryable(backoff = @Backoff(delay = 2000), retryFor = SQLException.class, maxAttempts = 10)
    public ResponseEntity<String> chamar() throws SQLException {
        //System.out.println("CHAMANDO ERRO");
        //throw new SQLException();
        return ResponseEntity.ok().body("Sucesso");
    }

}
