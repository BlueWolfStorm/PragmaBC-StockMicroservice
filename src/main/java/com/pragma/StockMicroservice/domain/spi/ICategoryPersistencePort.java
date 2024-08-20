package com.pragma.StockMicroservice.domain.spi;

import com.pragma.StockMicroservice.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryPersistencePort {
    void insert(Category category);
    Page<Category> getAllCategories(Pageable pageable);
}
