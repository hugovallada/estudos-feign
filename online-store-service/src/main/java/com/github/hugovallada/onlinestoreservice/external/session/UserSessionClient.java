package com.github.hugovallada.onlinestoreservice.external.session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.github.hugovallada.onlinestoreservice.external.session.dto.UserSessionValidatorResponse;

import feign.Param;
import feign.QueryMap;
import feign.RequestLine;


public interface UserSessionClient {

    @RequestLine("GET /user-sessions/validate?sessionId={sessionId}")
    UserSessionValidatorResponse validateSession(@Param("sessionId") UUID uuid);

    @RequestLine("GET /user-sessions/validate")
    UserSessionValidatorResponse validateSession(@QueryMap ValidateSessionRequest request);


    @RequestLine("GET /user-sessions/validate")
    UserSessionValidatorResponse validateSessionWithMaps(@QueryMap Map<String, Object> queryMap);

    default UserSessionValidatorResponse validateSessionDefault(UUID sessionId) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("sessionId", sessionId.toString());
        return validateSessionWithMaps(queryMap);
    }
}
