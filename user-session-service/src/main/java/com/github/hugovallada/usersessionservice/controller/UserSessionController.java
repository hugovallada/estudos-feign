package com.github.hugovallada.usersessionservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.github.hugovallada.usersessionservice.dto.UserSessionValidatorResponse;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserSessionController {
    
    @GetMapping("/user-sessions/validate")
    public UserSessionValidatorResponse getMethodName(@RequestParam("sessionId") UUID sessionId) {
        boolean isValid = UUID.fromString("a734c3b5-fddb-49cb-a3c2-1dbaae90647f").equals(sessionId);
        System.out.println(isValid);
        return new UserSessionValidatorResponse(isValid, sessionId);
    }
    

}
