package com.devops.onlineshopbackend.service;

import com.devops.onlineshopbackend.model.Basket;
import com.devops.onlineshopbackend.model.Product;
import com.devops.onlineshopbackend.repo.BasketRepo;
import com.devops.onlineshopbackend.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {
    private BasketRepo basketRepo;
    private ProductRepository productRepo;
    @Autowired
    public BasketService(BasketRepo basketRepo, ProductRepository productRepo){
        this.basketRepo = basketRepo;
        this.productRepo = productRepo;
    }
    public void addBasket(Long id){
        productRepo.findById(id).ifPresent(product->{
            Basket basket = new Basket();
            basket.setProduct(product);
            basketRepo.save(basket);
        });
    }
    public void deleteFromBasket(Long productId){
        basketRepo.findByProductId(productId).ifPresent(basket -> {
            basketRepo.delete(basket);
        });
    }
    public List<Product> getAll(){
        List<Basket> baskets = basketRepo.findAll();
        List<Product> products = new ArrayList<>();
        for(Basket i : baskets){
            products.add(i.getProduct());
        }
        return products;
    }
}
