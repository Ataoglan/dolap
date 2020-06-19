package com.example.dolapcase.repository;

import com.example.dolapcase.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String catName);
    Boolean existsByName(String catName);
}
