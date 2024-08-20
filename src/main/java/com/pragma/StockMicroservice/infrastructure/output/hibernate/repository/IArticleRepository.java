package com.pragma.StockMicroservice.infrastructure.output.hibernate.repository;

import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Optional<ArticleEntity> findByName(String name);
}
