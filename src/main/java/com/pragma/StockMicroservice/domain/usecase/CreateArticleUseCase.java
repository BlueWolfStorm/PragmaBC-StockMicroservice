package com.pragma.StockMicroservice.domain.usecase;

import com.pragma.StockMicroservice.domain.api.ICreateArticleServicePort;
import com.pragma.StockMicroservice.domain.model.Article;
import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.domain.spi.IArticlePersistencePort;
import com.pragma.StockMicroservice.domain.usecase.exception.MaximumLimitExceededException;
import com.pragma.StockMicroservice.domain.usecase.exception.NoCategoriesRepeated;

public class CreateArticleUseCase implements ICreateArticleServicePort {
    private final IArticlePersistencePort articlePersistencePort;

    public CreateArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }

    @Override
    public void createArticle(Article article) {
        if (article.getCategories().isEmpty() || article.getCategories().size() > 3)
            throw new MaximumLimitExceededException(1, 3);

        for (Category category : article.getCategories())
            if (article.getCategories().stream().filter(c -> c.getName().equals(category.getName())).count() > 1)
                throw new NoCategoriesRepeated();

        this.articlePersistencePort.insertArticle(article);
    }
}
