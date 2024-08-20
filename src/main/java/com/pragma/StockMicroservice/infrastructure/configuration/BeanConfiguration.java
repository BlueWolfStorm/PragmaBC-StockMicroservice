package com.pragma.StockMicroservice.infrastructure.configuration;

import com.pragma.StockMicroservice.domain.api.*;
import com.pragma.StockMicroservice.domain.spi.IArticlePersistencePort;
import com.pragma.StockMicroservice.domain.spi.ICategoryPersistencePort;
import com.pragma.StockMicroservice.domain.spi.IManufacturerPersistencePort;
import com.pragma.StockMicroservice.domain.usecase.*;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.adapter.ArticleJimmerAdapter;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.adapter.CategoryJimmerAdapter;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.adapter.ManufacturerJimmerAdapter;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper.ArticleEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper.CategoryEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper.ManufacturerEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.repository.IArticleRepository;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.repository.ICategoryRepository;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.repository.IManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    private final IManufacturerRepository manufacturerRepository;
    private final ManufacturerEntityMapper manufacturerEntityMapper;

    private final IArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;

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

    @Bean
    public IManufacturerPersistencePort manufacturerPersistencePort() {
        return new ManufacturerJimmerAdapter(manufacturerRepository, manufacturerEntityMapper);
    }

    @Bean
    public ICreateManufacturerServicePort createManufacturerServicePort() {
        return new CreateManufacturerUseCase(manufacturerPersistencePort());
    }

    @Bean
    public IGetManufacturerServicePort getManufacturerServicePort() {
        return new GetManufacturerUseCase(manufacturerPersistencePort());
    }

    @Bean
    public IArticlePersistencePort articlePersistencePort() {
        return new ArticleJimmerAdapter(articleRepository, manufacturerRepository, categoryRepository, articleEntityMapper, manufacturerEntityMapper, categoryEntityMapper);
    }

    @Bean
    ICreateArticleServicePort createArticleServicePort() {
        return new CreateArticleUseCase(articlePersistencePort());
    }
}
