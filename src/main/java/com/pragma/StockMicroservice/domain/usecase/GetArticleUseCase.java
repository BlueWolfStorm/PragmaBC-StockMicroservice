package com.pragma.StockMicroservice.domain.usecase;

import com.pragma.StockMicroservice.domain.api.IGetArticleServicePort;
import com.pragma.StockMicroservice.domain.model.Article;
import com.pragma.StockMicroservice.domain.spi.IArticlePersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class GetArticleUseCase implements IGetArticleServicePort {
    IArticlePersistencePort articlePersistencePort;

    public GetArticleUseCase(IArticlePersistencePort articlePersistencePort) {
        this.articlePersistencePort = articlePersistencePort;
    }

    @Override
    public Page<Article> getAllCategories(int page,
                                          int size,
                                          boolean sortDesc,
                                          String articleName,
                                          String articleManufacturer,
                                          String articleCategory) {
        Pageable pageable;
        if (sortDesc) pageable = PageRequest.of(page, size, Sort
                .by("name")
                .descending());
        else pageable = PageRequest.of(page, size, Sort
                .by("name")
                .ascending());

        return articlePersistencePort.getArticles(pageable, articleName, articleManufacturer, articleCategory);
    }
}
