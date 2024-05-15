package com.github.hugovallada.usersessionservice.dto;

import java.util.UUID;

public record UserSessionValidatorResponse(boolean valid, UUID sessionId) {
    
}
