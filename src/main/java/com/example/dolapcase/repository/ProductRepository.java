package com.example.dolapcase.repository;

import com.example.dolapcase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Boolean existsByName(String name);
    Optional<Product> findByName(String name);

}
