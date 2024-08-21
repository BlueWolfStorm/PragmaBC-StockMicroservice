package com.pragma.StockMicroservice.application.mapper.manufacturer;

import com.pragma.StockMicroservice.application.dto.manufacturer.ManufacturerResponse;
import com.pragma.StockMicroservice.domain.model.Manufacturer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ManufacturerResponseMapper {
    ManufacturerResponse toManufacturerResponse(Manufacturer manufacturer);

    Manufacturer toManufacturer(ManufacturerResponse manufacturerResponse);

    default Page<Manufacturer> toManufacturerPage(Page<ManufacturerResponse> manufacturerResponsePage) {
        return manufacturerResponsePage.map(this::toManufacturer);
    }

    default Page<ManufacturerResponse> toManufacturerResponsePage(Page<Manufacturer> manufacturerPage) {
        return manufacturerPage.map(this::toManufacturerResponse);
    }
}
