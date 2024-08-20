package com.pragma.StockMicroservice.domain.usecase;

import com.pragma.StockMicroservice.domain.api.IGetManufacturerServicePort;
import com.pragma.StockMicroservice.domain.model.Manufacturer;
import com.pragma.StockMicroservice.domain.spi.IManufacturerPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class GetManufacturerUseCase implements IGetManufacturerServicePort {
    IManufacturerPersistencePort manufacturerPersistencePort;

    public GetManufacturerUseCase(IManufacturerPersistencePort manufacturerPersistencePort) {
        this.manufacturerPersistencePort = manufacturerPersistencePort;
    }

    @Override
    public Page<Manufacturer> getAllCategories(int page, int size, boolean sortDesc) {
        Pageable pageable;
        if(sortDesc)
            pageable = PageRequest.of(page, size, Sort.by("name").descending());
        else
            pageable = PageRequest.of(page, size, Sort.by("name").ascending());

        return manufacturerPersistencePort.getAllManufactures(pageable);
    }
}
