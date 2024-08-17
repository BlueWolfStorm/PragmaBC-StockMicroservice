package com.pragma.StockMicroservice.domain.api;

import com.pragma.StockMicroservice.domain.model.Category;
import org.springframework.data.domain.Page;

public interface IGetCategoryServicePort {
    Page<Category> getAllCategories(int page, int size, boolean sortDesc);
}
