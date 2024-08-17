package com.pragma.StockMicroservice.application.mapper;

import com.pragma.StockMicroservice.application.dto.CategoryRequest;
import com.pragma.StockMicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoryRequestMapper {
    Category toCategory(CategoryRequest categoryRequest);
}
