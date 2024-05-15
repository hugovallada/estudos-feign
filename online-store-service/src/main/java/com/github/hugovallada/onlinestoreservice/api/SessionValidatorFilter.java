package com.github.hugovallada.onlinestoreservice.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.github.hugovallada.onlinestoreservice.external.session.UserSessionClient;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionValidatorFilter implements Filter {

    private final UserSessionClient userSessionClient;

    public SessionValidatorFilter(UserSessionClient userSessionClient) {
        this.userSessionClient = userSessionClient;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Chamando");

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String sessionId = httpServletRequest.getHeader("x-session-id");

        if (Objects.isNull(sessionId)) {
            sessionId = "a734c3b5-fddb-49cb-a3c2-1dbaae90647f";
        }
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("sessionId", sessionId);
        final var sessionResponse = userSessionClient.validateSessionWithMaps(queryMap);
        if (!sessionResponse.valid()) {
            httpServletResponse.sendError(HttpStatus.FORBIDDEN.value());
            return;
        }
        chain.doFilter(request, response);
    }

}
