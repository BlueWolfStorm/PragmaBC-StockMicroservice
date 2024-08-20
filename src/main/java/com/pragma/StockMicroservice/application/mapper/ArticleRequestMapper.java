package com.pragma.StockMicroservice.application.mapper;

import com.pragma.StockMicroservice.application.dto.ArticleRequest;
import com.pragma.StockMicroservice.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ArticleRequestMapper {
    Article toArticle(ArticleRequest articleRequest);
    ArticleRequest toArticleRequest(Article article);
}
