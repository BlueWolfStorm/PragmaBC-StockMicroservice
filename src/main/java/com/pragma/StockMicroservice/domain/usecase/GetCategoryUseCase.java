package com.pragma.StockMicroservice.domain.usecase;

import com.pragma.StockMicroservice.domain.api.IGetCategoryServicePort;
import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.domain.spi.ICategoryPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class GetCategoryUseCase implements IGetCategoryServicePort {
    ICategoryPersistencePort categoryPersistencePort;

    public GetCategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Page<Category> getAllCategories(int page, int size, boolean sortDesc) {
        Pageable pageable;
        if(sortDesc)
            pageable = PageRequest.of(page, size, Sort.by("name").descending());
        else
            pageable = PageRequest.of(page, size, Sort.by("name").ascending());

        return categoryPersistencePort.getAllCategories(pageable);
    }
}
