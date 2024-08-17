package com.pragma.StockMicroservice.domain.api;

import com.pragma.StockMicroservice.domain.model.Manufacturer;

public interface ICreateManufacturerServicePort {
    void createManufacture(Manufacturer manufacturer);
}
