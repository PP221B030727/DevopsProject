package com.devops.onlineshopbackend.repo;

import com.devops.onlineshopbackend.model.Basket;
import com.devops.onlineshopbackend.model.Product;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitialDataRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitialDataRunner.class);
    private final ProductRepository productRepository;
    private final BasketRepo basketRepo;
    @Override
    public void run(String... args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder().name("Banana").price(40.0).description("from home").imageUrl("https://images.immediate.co.uk/production/volatile/sites/30/2017/01/Bunch-of-bananas-67e91d5.jpg").build());
        products.add(Product.builder().name("Apple").price(30.0).description("from Chine").imageUrl("https://rg.ru/uploads/images/199/33/68/iStock-1158470655.jpg").build());
        products.add(Product.builder().name("Peach").price(35.0).description("from Kazakhstan").imageUrl("https://glycemic-index.net/images/FVRSYndNy8.webp").build());
        products.add(Product.builder().name("Pineapple").price(60.0).description("from Chine").imageUrl("https://s3.amazonaws.com/YouGarden/Web/500x500/340031_1.jpg").build());
        products.add(Product.builder().name("Orange").price(50.0).description("Good sort").imageUrl("https://befreshcorp.net/wp-content/uploads/2017/07/product-packshot-Orange-558x600.jpg").build());
        products.add(Product.builder().name("Strawberry").price(25.0).description("from Chine").imageUrl("https://clv.h-cdn.co/assets/15/22/2048x2048/square-1432664914-strawberry-facts1.jpg").build());
        productRepository.saveAll(products);
        logger.info("Auto-adding data for Products");

    }
}

