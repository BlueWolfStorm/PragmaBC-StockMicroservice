package com.pragma.StockMicroservice.domain.usecase;

import com.pragma.StockMicroservice.domain.api.ICreateCategoryServicePort;
import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.domain.spi.ICategoryPersistencePort;
import com.pragma.StockMicroservice.domain.usecase.exception.MaximumLimitExceededException;
import com.pragma.StockMicroservice.domain.usecase.exception.NoCategoryDescriptionBlankFieldException;
import com.pragma.StockMicroservice.domain.usecase.exception.NoCategoryNameBlankFieldException;

public class CreateCategoryUseCase implements ICreateCategoryServicePort {
    private final ICategoryPersistencePort categoryPersistencePort;
    private static final int MAX_NAME_LENGTH = 50;
    private static final int MAX_DESCRIPTION_LENGTH = 90;

    public CreateCategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void createCategory(Category category) {
        if (category.getName().isBlank())
            throw new NoCategoryNameBlankFieldException();
        else if (category.getDescription().isBlank())
            throw new NoCategoryDescriptionBlankFieldException();
        else if (category.getName().length() > MAX_NAME_LENGTH)
            throw new MaximumLimitExceededException(MAX_NAME_LENGTH);
        else if (category.getDescription().length() > MAX_DESCRIPTION_LENGTH)
            throw new MaximumLimitExceededException(MAX_DESCRIPTION_LENGTH);

        categoryPersistencePort.insert(category);
    }
}
