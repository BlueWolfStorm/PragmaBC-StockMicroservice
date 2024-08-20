package com.pragma.StockMicroservice.domain.usecase;

import com.pragma.StockMicroservice.domain.api.ICreateManufacturerServicePort;
import com.pragma.StockMicroservice.domain.model.Manufacturer;
import com.pragma.StockMicroservice.domain.spi.IManufacturerPersistencePort;
import com.pragma.StockMicroservice.domain.usecase.exception.MaximumLimitExceededException;
import com.pragma.StockMicroservice.domain.usecase.exception.NoManufacturerDescriptionBlankFieldException;
import com.pragma.StockMicroservice.domain.usecase.exception.NoManufacturerNameBlankFieldException;

public class CreateManufacturerUseCase implements ICreateManufacturerServicePort {
    private final IManufacturerPersistencePort manufacturerPersistencePort;
    private static final int MAXIMUM_NAME_LIMIT = 50;
    private static final int MAXIMUM_DESCRIPTION_LIMIT = 120;

    public CreateManufacturerUseCase(IManufacturerPersistencePort manufacturerPersistencePort) {
        this.manufacturerPersistencePort = manufacturerPersistencePort;
    }

    @Override
    public void createManufacture(Manufacturer manufacturer) {
        if (manufacturer.getName().isEmpty())
            throw new NoManufacturerNameBlankFieldException();
        else if (manufacturer.getDescription().isEmpty())
            throw new NoManufacturerDescriptionBlankFieldException();
        else if (manufacturer.getName().length() > MAXIMUM_NAME_LIMIT)
            throw new MaximumLimitExceededException(MAXIMUM_NAME_LIMIT);
        else if (manufacturer.getDescription().length() > MAXIMUM_DESCRIPTION_LIMIT)
            throw new MaximumLimitExceededException(MAXIMUM_DESCRIPTION_LIMIT);

        manufacturerPersistencePort.insertManufacture(manufacturer);
    }
}
