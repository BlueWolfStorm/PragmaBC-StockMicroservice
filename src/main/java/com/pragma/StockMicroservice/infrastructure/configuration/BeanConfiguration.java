package com.pragma.StockMicroservice.infrastructure.configuration;

import com.pragma.StockMicroservice.domain.api.ICreateCategoryServicePort;
import com.pragma.StockMicroservice.domain.api.IGetCategoryServicePort;
import com.pragma.StockMicroservice.domain.spi.ICategoryPersistencePort;
import com.pragma.StockMicroservice.domain.usecase.CreateCategoryUseCase;
import com.pragma.StockMicroservice.domain.usecase.GetCategoryUseCase;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.adapter.CategoryJimmerAdapter;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper.CategoryEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryJimmerAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICreateCategoryServicePort createCategoryServicePort() {
        return new CreateCategoryUseCase(categoryPersistencePort());
    }

    @Bean
    public IGetCategoryServicePort getCategoryServicePort() {
        return new GetCategoryUseCase(categoryPersistencePort());
    }
}
