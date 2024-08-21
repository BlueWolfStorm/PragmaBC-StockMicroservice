package com.pragma.StockMicroservice.application.mapper;

import com.pragma.StockMicroservice.application.dto.category.CategoryResponse;
import com.pragma.StockMicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoryResponseMapper {
    CategoryResponse toCategoryResponse(Category category);

    Category toCategory(CategoryResponse categoryResponse);

    default Page<CategoryResponse> toCategoryResponsePage(Page<Category> categoryPage) {
        return categoryPage.map(this::toCategoryResponse);
    }

    default Page<Category> toCategoryPage(Page<CategoryResponse> categoryResponsePage) {
        return categoryResponsePage.map(this::toCategory);
    }
}
