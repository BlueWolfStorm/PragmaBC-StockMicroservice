package com.pragma.StockMicroservice.infrastructure.output.jimmer.repository;

import com.pragma.StockMicroservice.infrastructure.output.jimmer.entity.ArticleEntity;
import org.babyfish.jimmer.spring.repository.JRepository;

import java.util.Optional;

public interface IArticleRepository extends JRepository<ArticleEntity, Long> {
    Optional<ArticleEntity> findByName(String name);
}
