package com.devops.onlineshopbackend.repo;

import com.devops.onlineshopbackend.model.Basket;
import com.devops.onlineshopbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM basket WHERE basket.product_id = :productId")
    Optional<Basket> findByProductId(@Param("productId") Long productId);
}
