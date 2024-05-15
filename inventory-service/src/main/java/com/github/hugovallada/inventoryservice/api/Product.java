package com.github.hugovallada.inventoryservice.api;

import java.util.UUID;

public record Product(UUID id, String name, int stock) {
    
}
