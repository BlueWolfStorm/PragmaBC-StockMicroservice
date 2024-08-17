package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.ManufacturerRequest;

public interface IManufacturerHandler {
    void insertManufacturer(ManufacturerRequest manufacturerRequest);
}
