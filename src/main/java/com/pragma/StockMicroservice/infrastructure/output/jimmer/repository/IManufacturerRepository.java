package com.pragma.StockMicroservice.infrastructure.output.jimmer.repository;

import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.ManufacturerEntity;
import org.babyfish.jimmer.spring.repository.JRepository;

import java.util.Optional;

public interface IManufacturerRepository extends JRepository<ManufacturerEntity, Long> {
    Optional<ManufacturerEntity> findByName(String name);
}
