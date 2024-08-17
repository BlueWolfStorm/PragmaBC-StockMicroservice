package com.pragma.StockMicroservice.domain.spi;

import com.pragma.StockMicroservice.domain.model.Category;
import org.springframework.data.domain.Page;

public interface ICategoryPersistencePort {
    Category insert(Category category);
    Page<Category> getAllCategoriesAsc(int pageIndex, int pageSize);
    Page<Category> getAllCategoriesDesc(int pageIndex, int pageSize);
}
