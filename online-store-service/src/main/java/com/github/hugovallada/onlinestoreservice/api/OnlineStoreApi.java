package com.github.hugovallada.onlinestoreservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.hugovallada.onlinestoreservice.external.inventory.CreateProductRequest;
import com.github.hugovallada.onlinestoreservice.external.inventory.CreateProductResponse;
import com.github.hugovallada.onlinestoreservice.external.inventory.InventoryServiceClient;

@RestController
public class OnlineStoreApi {

    private final InventoryServiceClient inventoryServiceClient;

    public OnlineStoreApi(@Autowired InventoryServiceClient inventoryServiceClient) {
        this.inventoryServiceClient = inventoryServiceClient;
    }



    @PostMapping("/online-store/products")
    public CreateProductResponse createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return inventoryServiceClient.createProduct(createProductRequest);
    }
    
}
