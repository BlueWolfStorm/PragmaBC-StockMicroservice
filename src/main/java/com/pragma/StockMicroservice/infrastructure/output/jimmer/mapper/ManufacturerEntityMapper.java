package com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper;

import com.pragma.StockMicroservice.domain.model.Manufacturer;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.ManufacturerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ManufacturerEntityMapper {
    ManufacturerEntity toManufacturerEntity(Manufacturer manufacturer);
    Manufacturer toManufacturer(ManufacturerEntity manufacturerEntity);
}
