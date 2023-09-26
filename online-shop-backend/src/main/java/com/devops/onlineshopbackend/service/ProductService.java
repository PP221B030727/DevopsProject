package com.devops.onlineshopbackend.service;

import com.devops.onlineshopbackend.model.Product;
import com.devops.onlineshopbackend.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);


    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        int cnt = 10;
        while (cnt!=0){
            logger.info(String.format("cnt is : %d" , cnt));
            System.out.println(cnt);
            cnt-=1;
        }
        return productRepository.findAll();
    }

    public List<Product> getAllProductByCategoryId(Long categoryId) {
        return productRepository.findAllProductByCategoryId(categoryId);
    }

    public Optional<Product> getProductByCategory(Long categoryId, Long productId) {
        return productRepository.findProductByCategoryIdAndId(categoryId, productId);
    }
}
