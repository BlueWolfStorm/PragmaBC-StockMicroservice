package com.pragma.StockMicroservice.infrastructure.output.hibernate.adapter;

import com.pragma.StockMicroservice.domain.model.Article;
import com.pragma.StockMicroservice.domain.spi.IArticlePersistencePort;
import com.pragma.StockMicroservice.infrastructure.exception.NoCategoryFoundException;
import com.pragma.StockMicroservice.infrastructure.exception.NoManufacturerFoundException;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.ArticleEntity;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.CategoryEntity;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.ManufacturerEntity;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.mapper.ArticleEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.repository.IArticleRepository;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.repository.ICategoryRepository;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.repository.IManufacturerRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class ArticleJimmerAdapter implements IArticlePersistencePort {
    private final IArticleRepository articleRepository;
    private final ArticleEntityMapper articleEntityMapper;
    private final ICategoryRepository categoryRepository;
    private final IManufacturerRepository manufacturerRepository;

    @Override
    public void insertArticle(Article article) {
        ArticleEntity articleEntity = articleEntityMapper.toArticleEntityWithoutId(article);

        Optional<ManufacturerEntity> manufacturer = manufacturerRepository.findByName(article.getManufacturer().getName());
        if(manufacturer.isPresent())
            articleEntity.setManufacturer(manufacturer.get());
        else
            throw new NoManufacturerFoundException(articleEntity.getManufacturer().getName());

        List<CategoryEntity> categories = new ArrayList<>();
        for(CategoryEntity category : articleEntity.getCategories()) {
            Optional<CategoryEntity> categoryEntity = categoryRepository.findByName(category.getName());
            if(categoryEntity.isPresent())
                categories.add(categoryEntity.get());
            else
                throw new NoCategoryFoundException(category.getName());
        }

        articleEntity.setCategories(categories);
        articleRepository.save(articleEntity);
    }
}
