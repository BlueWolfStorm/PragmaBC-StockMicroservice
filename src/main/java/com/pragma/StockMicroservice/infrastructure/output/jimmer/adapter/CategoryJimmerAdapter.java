package com.pragma.StockMicroservice.infrastructure.output.jimmer.adapter;

import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.domain.spi.ICategoryPersistencePort;
import com.pragma.StockMicroservice.infrastructure.exception.CategoryAlreadyExistException;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper.CategoryEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
public class CategoryJimmerAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;


    @Override
    public void insert(Category category) {
        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new CategoryAlreadyExistException();
        }

        categoryEntityMapper.toCategory(categoryRepository.insert(categoryEntityMapper.toCategoryEntity(category)));
    }

    @Override
    public Page<Category> getAllCategoriesAsc(int page, int size) {
        return categoryEntityMapper.toCategoryPage(categoryRepository.findAllOrderByNameDesc(page, size));
    }

    @Override
    public Page<Category> getAllCategoriesDesc(int page, int size) {
        return categoryEntityMapper.toCategoryPage(categoryRepository.findAllOrderByName(page, size));
    }
}
