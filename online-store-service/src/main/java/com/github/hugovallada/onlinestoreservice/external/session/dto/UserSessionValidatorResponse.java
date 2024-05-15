package com.github.hugovallada.onlinestoreservice.external.session.dto;

import java.util.UUID;

public record UserSessionValidatorResponse(boolean valid, UUID sessionId) {
    
}
