package com.pragma.StockMicroservice.application.mapper;

import com.pragma.StockMicroservice.application.dto.ManufacturerRequest;
import com.pragma.StockMicroservice.domain.model.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ManufacturerRequestMapper {
    Manufacturer toManufacturer(ManufacturerRequest manufacturerRequest);
    ManufacturerRequest toManufacturerRequest(Manufacturer manufacturer);
}
