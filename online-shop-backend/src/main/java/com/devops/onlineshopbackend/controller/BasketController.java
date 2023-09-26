package com.devops.onlineshopbackend.controller;

import com.devops.onlineshopbackend.exception.ProductNotFoundException;
import com.devops.onlineshopbackend.model.Product;
import com.devops.onlineshopbackend.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getBasket(){
        return ResponseEntity.ok(basketService.getAll());
    }
    @DeleteMapping("delete/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable Long productId){
        basketService.deleteFromBasket(productId);
        System.out.println("Hello world");
        return ResponseEntity.ok("Product was deleted");
    }
}
