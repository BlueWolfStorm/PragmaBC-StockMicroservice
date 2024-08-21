package com.pragma.StockMicroservice.domain.spi;

import com.pragma.StockMicroservice.domain.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IArticlePersistencePort {
    void insertArticle(Article article);

    Page<Article> getArticles(Pageable pageable, String articleName, String articleManufacturer, String articleCategory);
}
