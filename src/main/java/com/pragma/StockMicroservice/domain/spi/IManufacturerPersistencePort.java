package com.pragma.StockMicroservice.domain.spi;

import com.pragma.StockMicroservice.domain.model.Manufacturer;
import org.springframework.data.domain.Page;

public interface IManufacturerPersistencePort {
    void insertManufacture(Manufacturer manufacturer);
    Page<Manufacturer> getAllManufacturesAsc(int pageIndex, int pageSize);
    Page<Manufacturer> getAllManufacturesDesc(int pageIndex, int pageSize);
}
