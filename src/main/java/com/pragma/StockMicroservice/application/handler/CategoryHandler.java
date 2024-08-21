package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.category.CategoryRequest;
import com.pragma.StockMicroservice.application.dto.category.CategoryResponse;
import com.pragma.StockMicroservice.application.mapper.CategoryRequestMapper;
import com.pragma.StockMicroservice.application.mapper.CategoryResponseMapper;
import com.pragma.StockMicroservice.domain.api.ICreateCategoryServicePort;
import com.pragma.StockMicroservice.domain.api.IGetCategoryServicePort;
import com.pragma.StockMicroservice.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler {
    private final ICreateCategoryServicePort createCategoryServicePort;
    private final IGetCategoryServicePort getCategoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;

    @Override
    public void insertCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequestMapper.toCategory(categoryRequest);
        createCategoryServicePort.createCategory(category);
    }

    @Override
    public Page<CategoryResponse> getAllCategories(int page, int size, boolean sortDesc) {
        return categoryResponseMapper.toCategoryResponsePage(getCategoryServicePort.getAllCategories(page, size, sortDesc));
    }
}
