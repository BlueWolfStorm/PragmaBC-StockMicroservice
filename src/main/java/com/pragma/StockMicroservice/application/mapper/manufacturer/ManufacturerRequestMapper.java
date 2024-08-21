package com.pragma.StockMicroservice.application.mapper.manufacturer;

import com.pragma.StockMicroservice.application.dto.manufacturer.ManufacturerRequest;
import com.pragma.StockMicroservice.domain.model.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ManufacturerRequestMapper {
    Manufacturer toManufacturer(ManufacturerRequest manufacturerRequest);

    ManufacturerRequest toManufacturerRequest(Manufacturer manufacturer);

    default Page<Manufacturer> toManufacturerPage(Page<ManufacturerRequest> manufacturerRequestPage) {
        return manufacturerRequestPage.map(this::toManufacturer);
    }

    default Page<ManufacturerRequest> toManufacturerRequestPage(Page<Manufacturer> manufacturerPage) {
        return manufacturerPage.map(this::toManufacturerRequest);
    }
}
