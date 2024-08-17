package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.CategoryRequest;

public interface ICategoryHandler {
    void insertCategory(CategoryRequest categoryRequest);
}
