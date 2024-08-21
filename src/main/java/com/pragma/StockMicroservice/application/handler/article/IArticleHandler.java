package com.pragma.StockMicroservice.application.handler.article;

import com.pragma.StockMicroservice.application.dto.article.ArticleRequest;
import com.pragma.StockMicroservice.application.dto.article.ArticleResponse;
import org.springframework.data.domain.Page;

public interface IArticleHandler {
    void insertArticle(ArticleRequest articleRequest);

    Page<ArticleResponse> getAllCategories(int page,
                                           int size,
                                           boolean sortDesc,
                                           String articleName,
                                           String articleManufacturer,
                                           String articleCategory);
}
