package com.pragma.StockMicroservice.domain.spi;

import com.pragma.StockMicroservice.domain.model.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IManufacturerPersistencePort {
    void insertManufacture(Manufacturer manufacturer);
    Page<Manufacturer> getAllManufactures(Pageable pageable);
}
