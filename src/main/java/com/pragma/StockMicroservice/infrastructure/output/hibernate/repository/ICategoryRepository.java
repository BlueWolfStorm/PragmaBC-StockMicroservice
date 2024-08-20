package com.pragma.StockMicroservice.infrastructure.output.hibernate.repository;

import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
