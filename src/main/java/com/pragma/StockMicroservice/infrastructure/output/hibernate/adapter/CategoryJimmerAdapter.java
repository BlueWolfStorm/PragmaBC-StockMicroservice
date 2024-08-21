package com.pragma.StockMicroservice.infrastructure.output.hibernate.adapter;

import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.domain.spi.ICategoryPersistencePort;
import com.pragma.StockMicroservice.infrastructure.exception.CategoryAlreadyExistException;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.mapper.CategoryEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class CategoryJimmerAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;


    @Override
    public void insert(Category category) {
        if (categoryRepository
                .findByName(category.getName())
                .isPresent()) {
            throw new CategoryAlreadyExistException();
        }

        categoryEntityMapper.toCategory(categoryRepository.save(categoryEntityMapper.toCategoryEntity(category)));
    }

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryEntityMapper.toCategoryPage(categoryRepository.findAll(pageable));
    }
}
