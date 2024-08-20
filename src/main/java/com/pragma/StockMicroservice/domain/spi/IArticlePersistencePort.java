package com.pragma.StockMicroservice.domain.spi;

import com.pragma.StockMicroservice.domain.model.Article;

public interface IArticlePersistencePort {
    void insertArticle(Article article);
}
