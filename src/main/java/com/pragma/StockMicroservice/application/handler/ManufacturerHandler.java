package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.ManufacturerRequest;
import com.pragma.StockMicroservice.application.mapper.ManufacturerRequestMapper;
import com.pragma.StockMicroservice.domain.api.ICreateManufacturerServicePort;
import com.pragma.StockMicroservice.domain.model.Manufacturer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ManufacturerHandler implements IManufacturerHandler{
    private final ICreateManufacturerServicePort createManufacturerServicePort;
    private final ManufacturerRequestMapper manufacturerRequestMapper;

    @Override
    public void insertManufacturer(ManufacturerRequest manufacturerRequest) {
        Manufacturer manufacturer = manufacturerRequestMapper.toManufacturer(manufacturerRequest);
        createManufacturerServicePort.createManufacture(manufacturer);
    }
}
