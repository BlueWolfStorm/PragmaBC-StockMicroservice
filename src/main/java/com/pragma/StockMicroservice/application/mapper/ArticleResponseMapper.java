package com.pragma.StockMicroservice.application.mapper;

import com.pragma.StockMicroservice.application.dto.article.ArticleResponse;
import com.pragma.StockMicroservice.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ArticleResponseMapper {
    ArticleResponse toArticleResponse(Article article);

    Article toArticle(ArticleResponse articleResponse);

    default Page<ArticleResponse> toArticleResponsePage(Page<Article> articlePage) {
        return articlePage.map(this::toArticleResponse);
    }

    default Page<Article> toArticlePage(Page<ArticleResponse> articleResponsePage) {
        return articleResponsePage.map(this::toArticle);
    }
}
