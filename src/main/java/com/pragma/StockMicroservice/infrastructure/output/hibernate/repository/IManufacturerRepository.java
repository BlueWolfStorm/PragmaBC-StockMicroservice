package com.pragma.StockMicroservice.infrastructure.output.hibernate.repository;

import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IManufacturerRepository extends JpaRepository<ManufacturerEntity, Long> {
    Optional<ManufacturerEntity> findByName(String name);
}
