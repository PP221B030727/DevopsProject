package com.devops.onlineshopbackend.controller;

import com.devops.onlineshopbackend.exception.ProductNotFoundException;
import com.devops.onlineshopbackend.model.Product;
import com.devops.onlineshopbackend.service.BasketService;
import com.devops.onlineshopbackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final BasketService basketService;
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId) {
        var product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }
    @PostMapping("/{productId}/toBasket")
    public ResponseEntity<String> toBasket(@PathVariable Long productId){
        try{
            basketService.addBasket(productId);
            return ResponseEntity.ok("Product was added!");
        }catch(ProductNotFoundException e){
            throw new ProductNotFoundException();
        }
    }
}
