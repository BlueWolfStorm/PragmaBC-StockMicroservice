package com.pragma.StockMicroservice.domain.spi;

import com.pragma.StockMicroservice.domain.model.Manufacturer;

public interface IManufacturerPersistencePort {
    void insertManufacture(Manufacturer manufacturer);
}
