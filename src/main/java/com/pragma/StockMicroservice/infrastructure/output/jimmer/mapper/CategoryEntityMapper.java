package com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper;

import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryEntityMapper {
    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);

    List<CategoryEntity> toCategoryEntityList(List<Category> categories);

    List<Category> toCategoryList(List<CategoryEntity> categoryEntities);
}
