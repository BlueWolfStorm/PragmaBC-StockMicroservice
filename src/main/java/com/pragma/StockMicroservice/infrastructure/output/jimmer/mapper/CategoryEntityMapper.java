package com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper;

import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryEntityMapper {
    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);

    default Page<Category> toCategoryPage(Page<CategoryEntity> categoryResponses){
        return categoryResponses.map(this::toCategory);
    }

    default Page<CategoryEntity> toCategoryEntityPage(Page<Category> categories){
        return categories.map(this::toCategoryEntity);
    }
}
