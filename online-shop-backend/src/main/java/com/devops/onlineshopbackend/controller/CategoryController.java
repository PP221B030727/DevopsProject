package com.devops.onlineshopbackend.controller;

import com.devops.onlineshopbackend.model.Category;
import com.devops.onlineshopbackend.model.Product;
import com.devops.onlineshopbackend.service.CategoryService;
import com.devops.onlineshopbackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable Long categoryId) {
        var category = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryId) {
        List<Product> products = productService.getAllProductByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<?> getProductByCategory(@PathVariable Long categoryId,
                                                  @PathVariable Long productId) {
        var product = productService.getProductByCategory(categoryId, productId);
        return ResponseEntity.ok(product);
    }
}
