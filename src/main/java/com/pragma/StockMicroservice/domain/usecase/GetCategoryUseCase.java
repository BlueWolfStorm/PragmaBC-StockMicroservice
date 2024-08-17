package com.pragma.StockMicroservice.domain.usecase;

import com.pragma.StockMicroservice.domain.api.IGetCategoryServicePort;
import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.domain.spi.ICategoryPersistencePort;
import org.springframework.data.domain.Page;

public class GetCategoryUseCase implements IGetCategoryServicePort {
    ICategoryPersistencePort categoryPersistencePort;

    public GetCategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Page<Category> getAllCategories(int page, int size, boolean sortDesc) {
        if(sortDesc) {
            return categoryPersistencePort.getAllCategoriesDesc(page, size);
        }

        return categoryPersistencePort.getAllCategoriesAsc(page, size);
    }
}
