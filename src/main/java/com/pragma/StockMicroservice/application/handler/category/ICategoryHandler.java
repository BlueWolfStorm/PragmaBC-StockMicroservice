package com.pragma.StockMicroservice.application.handler.category;

import com.pragma.StockMicroservice.application.dto.category.CategoryRequest;
import com.pragma.StockMicroservice.application.dto.category.CategoryResponse;
import org.springframework.data.domain.Page;

public interface ICategoryHandler {
    void insertCategory(CategoryRequest categoryRequest);

    Page<CategoryResponse> getAllCategories(int page,
                                            int size,
                                            boolean sortDesc);
}
