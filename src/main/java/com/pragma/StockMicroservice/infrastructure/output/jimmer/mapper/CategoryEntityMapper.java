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
        List<Category> categoryResponseList = categoryResponses.getContent().stream()
                .map(this::toCategory).toList();

        return new PageImpl<>(categoryResponseList);
    }
}
