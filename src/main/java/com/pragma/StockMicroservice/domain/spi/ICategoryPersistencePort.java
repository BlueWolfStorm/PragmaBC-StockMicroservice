package com.pragma.StockMicroservice.domain.spi;

import com.pragma.StockMicroservice.domain.model.Category;

public interface ICategoryPersistencePort {
    Category insert(Category category);

}
