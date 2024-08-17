package com.pragma.StockMicroservice.infrastructure.output.jimmer.adapter;

import com.pragma.StockMicroservice.domain.model.Manufacturer;
import com.pragma.StockMicroservice.domain.spi.IManufacturerPersistencePort;
import com.pragma.StockMicroservice.infrastructure.exception.ManufacturerAlreadyExistException;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.ManufacturerEntity;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper.ManufacturerEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.repository.IManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

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
        manufacturerRepository.insert(manufacturerEntity);
    }

    @Override
    public Page<Manufacturer> getAllManufacturesAsc(int pageIndex, int pageSize) {
        return manufacturerEntityMapper.toManufacturerPage(manufacturerRepository.findAllOrderByNameAsc(pageIndex, pageSize));
    }

    @Override
    public Page<Manufacturer> getAllManufacturesDesc(int pageIndex, int pageSize) {
        return manufacturerEntityMapper.toManufacturerPage(manufacturerRepository.findAllOrderByNameDesc(pageIndex, pageSize));
    }
}
