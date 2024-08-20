package com.pragma.StockMicroservice.infrastructure.output.hibernate.mapper;

import com.pragma.StockMicroservice.domain.model.Article;
import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.ArticleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ArticleEntityMapper {
    ArticleEntity toArticleEntity(Article article);

    @Mapping(target = "id", ignore = true)
    ArticleEntity toArticleEntityWithoutId(Article article);

    Article toArticle(ArticleEntity articleEntity);

    @Mapping(target = "id", ignore = true)
    Article toArticleWithoutId(ArticleEntity articleEntity);

}
