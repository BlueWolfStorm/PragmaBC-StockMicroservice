package com.pragma.StockMicroservice.infrastructure.output.hibernate.mapper;

import com.pragma.StockMicroservice.domain.model.Manufacturer;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.ManufacturerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ManufacturerEntityMapper {
    ManufacturerEntity toManufacturerEntity(Manufacturer manufacturer);
    Manufacturer toManufacturer(ManufacturerEntity manufacturerEntity);

    default Page<Manufacturer> toManufacturerPage(Page<ManufacturerEntity> manufacturerEntities){
        return manufacturerEntities.map(this::toManufacturer);
    }

    default Page<ManufacturerEntity> toManufacturerEntityPage(Page<Manufacturer> manufacturers){
        return manufacturers.map(this::toManufacturerEntity);
    }
}
