package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.manufacturer.ManufacturerRequest;
import com.pragma.StockMicroservice.application.dto.manufacturer.ManufacturerResponse;
import com.pragma.StockMicroservice.application.mapper.ManufacturerRequestMapper;
import com.pragma.StockMicroservice.application.mapper.ManufacturerResponseMapper;
import com.pragma.StockMicroservice.domain.api.ICreateManufacturerServicePort;
import com.pragma.StockMicroservice.domain.api.IGetManufacturerServicePort;
import com.pragma.StockMicroservice.domain.model.Manufacturer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ManufacturerHandler implements IManufacturerHandler {
    private final ICreateManufacturerServicePort createManufacturerServicePort;
    private final IGetManufacturerServicePort getManufacturerServicePort;
    private final ManufacturerRequestMapper manufacturerRequestMapper;
    private final ManufacturerResponseMapper manufacturerResponseMapper;

    @Override
    public void insertManufacturer(ManufacturerRequest manufacturerRequest) {
        Manufacturer manufacturer = manufacturerRequestMapper.toManufacturer(manufacturerRequest);
        createManufacturerServicePort.createManufacture(manufacturer);
    }

    @Override
    public Page<ManufacturerResponse> getAllManufacturers(int page, int size, boolean sortDesc) {
        return manufacturerResponseMapper.toManufacturerResponsePage(getManufacturerServicePort.getAllCategories(page, size, sortDesc));
    }
}
