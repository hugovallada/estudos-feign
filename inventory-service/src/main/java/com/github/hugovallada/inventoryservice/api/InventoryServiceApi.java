package com.github.hugovallada.inventoryservice.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryServiceApi {

    private static Map<UUID, Product> productMap = new HashMap<>();

    static {
        final var productId = UUID.fromString("41d42101-ed7d-4d17-bb55-78b05eab1448");
        productMap.put(productId, new Product(productId, "Phone", 5));
    }

    @PostMapping("/products")
    public CreateProductResponse createProduct(@RequestBody CreateProductRequest request) {
        String name = request.name();
        int initialStock = request.initialStock();
        final var product = new Product(UUID.randomUUID(), name, initialStock);
        productMap.put(product.id(), product);
        return new CreateProductResponse(product.id(), name, initialStock);
    }
    
}
