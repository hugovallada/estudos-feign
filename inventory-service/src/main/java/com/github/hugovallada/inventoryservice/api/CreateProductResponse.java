package com.github.hugovallada.inventoryservice.api;

import java.util.UUID;

public record CreateProductResponse(UUID productID, String name, int currentStock) {
    
}
