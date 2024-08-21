package com.pragma.StockMicroservice.application.handler.article;

import com.pragma.StockMicroservice.application.dto.article.ArticleRequest;
import com.pragma.StockMicroservice.application.dto.article.ArticleResponse;
import com.pragma.StockMicroservice.application.mapper.article.ArticleRequestMapper;
import com.pragma.StockMicroservice.application.mapper.article.ArticleResponseMapper;
import com.pragma.StockMicroservice.domain.api.ICreateArticleServicePort;
import com.pragma.StockMicroservice.domain.api.IGetArticleServicePort;
import com.pragma.StockMicroservice.domain.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleHandler implements IArticleHandler {
    private final ICreateArticleServicePort createArticleServicePort;
    private final IGetArticleServicePort getArticleServicePort;
    private final ArticleRequestMapper articleRequestMapper;
    private final ArticleResponseMapper articleResponseMapper;


    @Override
    public void insertArticle(ArticleRequest articleRequest) {
        Article article = articleRequestMapper.toArticle(articleRequest);
        createArticleServicePort.createArticle(article);
    }

    @Override
    public Page<ArticleResponse> getAllCategories(int page,
                                                  int size,
                                                  boolean sortDesc,
                                                  String articleName,
                                                  String articleManufacturer,
                                                  String articleCategory) {
        Page<Article> articles = getArticleServicePort.getAllCategories(page, size, sortDesc, articleName, articleManufacturer, articleCategory);
        return articleResponseMapper.toArticleResponsePage(articles);
    }
}
