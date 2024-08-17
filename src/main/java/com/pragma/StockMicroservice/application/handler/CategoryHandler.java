package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.CategoryRequest;
import com.pragma.StockMicroservice.application.mapper.CategoryRequestMapper;
import com.pragma.StockMicroservice.domain.api.ICreateCategoryServicePort;
import com.pragma.StockMicroservice.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler {
    private final ICreateCategoryServicePort createCategoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;

    @Override
    public void insertCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequestMapper.toCategory(categoryRequest);
        createCategoryServicePort.createCategory(category);
    }
}
