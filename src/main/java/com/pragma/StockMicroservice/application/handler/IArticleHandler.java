package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.ArticleRequest;

public interface IArticleHandler {
    void insertArticle(ArticleRequest articleRequest);
}
