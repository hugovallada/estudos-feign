package com.github.hugovallada.onlinestoreservice.external.inventory;

import java.util.UUID;

public record CreateProductResponse(UUID productID, String name, int currentStock) {
    
}
