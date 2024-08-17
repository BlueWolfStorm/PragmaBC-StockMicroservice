package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.CategoryRequest;
import com.pragma.StockMicroservice.application.dto.CategoryResponse;
import org.springframework.data.domain.Page;

public interface ICategoryHandler {
    void insertCategory(CategoryRequest categoryRequest);
    Page<CategoryResponse> getAllCategories(int page, int size, boolean sortDesc);
}
