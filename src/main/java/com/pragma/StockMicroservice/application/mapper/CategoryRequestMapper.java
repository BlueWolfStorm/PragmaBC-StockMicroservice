package com.pragma.StockMicroservice.application.mapper;

import com.pragma.StockMicroservice.application.dto.CategoryRequest;
import com.pragma.StockMicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;


@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoryRequestMapper {
    Category toCategory(CategoryRequest categoryRequest);
    CategoryRequest toCategoryRequest(Category category);

    default Page<Category> toCategoryPage(Page<CategoryRequest> categoryRequestPage){
        return categoryRequestPage.map(this::toCategory);
    }


    default Page<CategoryRequest> toCategoryRequestPage(Page<Category> categoryPage){
        return categoryPage.map(this::toCategoryRequest);
    }
}
