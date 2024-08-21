package com.pragma.StockMicroservice.application.mapper.article;

import com.pragma.StockMicroservice.application.dto.article.ArticleRequest;
import com.pragma.StockMicroservice.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticleRequestMapper {
    Article toArticle(ArticleRequest articleRequest);

    ArticleRequest toArticleRequest(Article article);

    default Page<Article> toArticlePage(Page<ArticleRequest> articleRequestPage) {
        return articleRequestPage.map(this::toArticle);
    }

    default Page<ArticleRequest> toArticleRequestPage(Page<Article> articlePage) {
        return articlePage.map(this::toArticleRequest);
    }
}
