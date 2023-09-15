package com.devops.onlineshopbackend.repo;

import com.devops.onlineshopbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
