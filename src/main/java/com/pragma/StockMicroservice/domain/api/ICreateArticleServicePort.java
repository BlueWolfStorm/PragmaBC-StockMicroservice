package com.pragma.StockMicroservice.domain.api;

import com.pragma.StockMicroservice.domain.model.Article;

public interface ICreateArticleServicePort {
    void createArticle(Article article);
}
