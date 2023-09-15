package com.devops.onlineshopbackend.repo;

import com.devops.onlineshopbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllProductByCategoryId(@Param("id")Long id);
    Optional<Product> findProductByCategoryIdAndId(@Param("categoryId")Long categoryId,@Param("productId") Long productId);
}
