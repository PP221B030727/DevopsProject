package com.devops.onlineshopbackend.service;

import com.devops.onlineshopbackend.model.Product;
import com.devops.onlineshopbackend.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductByCategoryId(Long categoryId) {
        return productRepository.findAllProductByCategoryId(categoryId);
    }

    public Optional<Product> getProductByCategory(Long categoryId, Long productId) {
        return productRepository.findProductByCategoryIdAndId(categoryId, productId);
    }
}
