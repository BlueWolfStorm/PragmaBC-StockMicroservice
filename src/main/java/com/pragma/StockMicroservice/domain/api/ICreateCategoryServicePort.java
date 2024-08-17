package com.pragma.StockMicroservice.domain.api;

import com.pragma.StockMicroservice.domain.model.Category;

public interface ICreateCategoryServicePort {
    void createCategory(Category category);
}
