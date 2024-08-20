package com.pragma.StockMicroservice.infrastructure.output.jimmer.adapter;

import com.pragma.StockMicroservice.domain.model.Article;
import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.domain.spi.IArticlePersistencePort;
import com.pragma.StockMicroservice.domain.usecase.exception.NoCategoriesRepeated;
import com.pragma.StockMicroservice.infrastructure.exception.NoCategoryFoundException;
import com.pragma.StockMicroservice.infrastructure.exception.NoManufacturerFoundException;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.ArticleEntity;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.CategoryEntity;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.ManufacturerEntity;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper.ArticleEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper.CategoryEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.mapper.ManufacturerEntityMapper;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.repository.IArticleRepository;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.repository.ICategoryRepository;
import com.pragma.StockMicroservice.infrastructure.output.jimmer.repository.IManufacturerRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ArticleJimmerAdapter implements IArticlePersistencePort {
    private final IArticleRepository articleRepository;
    private final IManufacturerRepository manufacturerRepository;
    private final ICategoryRepository categoryRepository;
    private final ArticleEntityMapper articleEntityMapper;
    private final ManufacturerEntityMapper manufacturerEntityMapper;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void insertArticle(Article article) {

        Optional<ManufacturerEntity> manufacturer = manufacturerRepository.findByName(article.getManufacturer().getName());
        if (manufacturer.isEmpty())
            throw new NoManufacturerFoundException(article.getManufacturer().getName());
        article.setManufacturer(manufacturerEntityMapper.toManufacturer(manufacturer.get()));

        List<Category> categories = new ArrayList<>();
        for (Category category : article.getCategories()) {
            Optional<CategoryEntity> categoryEntity = categoryRepository.findByName(category.getName());
            if (categoryEntity.isEmpty())
                throw new NoCategoryFoundException(category.getName());
            categories.add(categoryEntityMapper.toCategory(categoryEntity.get()));
        }
        article.setCategories(categories);

        ArticleEntity articleEntity = articleEntityMapper.toArticleEntityWithoutId(article);

        articleRepository.insert(articleEntity);
    }
}
