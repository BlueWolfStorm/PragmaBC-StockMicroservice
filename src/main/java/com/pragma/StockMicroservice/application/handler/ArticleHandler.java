package com.pragma.StockMicroservice.application.handler;

import com.pragma.StockMicroservice.application.dto.ArticleRequest;
import com.pragma.StockMicroservice.application.mapper.ArticleRequestMapper;
import com.pragma.StockMicroservice.application.mapper.ArticleResponseMapper;
import com.pragma.StockMicroservice.domain.api.ICreateArticleServicePort;
import com.pragma.StockMicroservice.domain.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleHandler implements IArticleHandler {
    private final ICreateArticleServicePort createArticleServicePort;
    private final ArticleRequestMapper articleRequestMapper;
    private final ArticleResponseMapper articleResponseMapper;


    @Override
    public void insertArticle(ArticleRequest articleRequest) {
        Article article = articleRequestMapper.toArticle(articleRequest);
        createArticleServicePort.createArticle(article);
    }
}
