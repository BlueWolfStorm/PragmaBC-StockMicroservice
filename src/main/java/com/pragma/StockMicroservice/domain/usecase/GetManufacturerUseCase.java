package com.pragma.StockMicroservice.domain.usecase;

import com.pragma.StockMicroservice.domain.api.IGetManufacturerServicePort;
import com.pragma.StockMicroservice.domain.model.Manufacturer;
import com.pragma.StockMicroservice.domain.spi.IManufacturerPersistencePort;
import org.springframework.data.domain.Page;

public class GetManufacturerUseCase implements IGetManufacturerServicePort {
    IManufacturerPersistencePort manufacturerPersistencePort;

    public GetManufacturerUseCase(IManufacturerPersistencePort manufacturerPersistencePort) {
        this.manufacturerPersistencePort = manufacturerPersistencePort;
    }

    @Override
    public Page<Manufacturer> getAllCategories(int page, int size, boolean sortDesc) {
        if(sortDesc) {
            return manufacturerPersistencePort.getAllManufacturesDesc(page, size);
        }

        return manufacturerPersistencePort.getAllManufacturesAsc(page, size);
    }
}
