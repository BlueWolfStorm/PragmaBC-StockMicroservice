package com.pragma.StockMicroservice.infrastructure.output.hibernate.adapter;

import com.pragma.StockMicroservice.domain.model.Manufacturer;
import com.pragma.StockMicroservice.domain.spi.IManufacturerPersistencePort;
import com.pragma.StockMicroservice.infrastructure.exception.ManufacturerAlreadyExistException;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.ManufacturerEntity;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.mapper.ManufacturerEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.repository.IManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class ManufacturerJimmerAdapter implements IManufacturerPersistencePort {
    private final IManufacturerRepository manufacturerRepository;
    private final ManufacturerEntityMapper manufacturerEntityMapper;

    @Override
    public void insertManufacture(Manufacturer manufacturer) {
        if (manufacturerRepository.findByName(manufacturer.getName()).isPresent()) {
            throw new ManufacturerAlreadyExistException();
        }

        ManufacturerEntity manufacturerEntity = manufacturerEntityMapper.toManufacturerEntity(manufacturer);
        manufacturerRepository.save(manufacturerEntity);
    }

    @Override
    public Page<Manufacturer> getAllManufactures(Pageable pageable) {
        return manufacturerEntityMapper.toManufacturerPage(manufacturerRepository.findAll(pageable));
    }
}
