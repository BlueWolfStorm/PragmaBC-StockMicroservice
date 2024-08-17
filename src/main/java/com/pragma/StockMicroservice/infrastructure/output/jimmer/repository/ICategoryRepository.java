package com.pragma.StockMicroservice.infrastructure.output.jimmer.repository;

import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.CategoryEntity;
import org.babyfish.jimmer.spring.repository.JRepository;

import java.util.Optional;

public interface ICategoryRepository extends JRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
