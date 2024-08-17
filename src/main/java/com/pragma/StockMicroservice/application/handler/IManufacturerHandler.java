package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.ManufacturerRequest;
import com.pragma.StockMicroservice.application.dto.ManufacturerResponse;
import org.springframework.data.domain.Page;

public interface IManufacturerHandler {
    void insertManufacturer(ManufacturerRequest manufacturerRequest);
    Page<ManufacturerResponse> getAllManufacturers(int page, int size, boolean sortDesc);
}
