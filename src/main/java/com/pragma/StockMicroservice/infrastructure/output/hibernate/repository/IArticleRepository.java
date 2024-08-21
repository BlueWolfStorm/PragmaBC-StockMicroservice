package com.pragma.StockMicroservice.infrastructure.output.hibernate.repository;

import com.pragma.StockMicroservice.infrastructure.output.hibernate.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Optional<ArticleEntity> findByName(String name);

    @Query("SELECT a FROM ARTICLE a JOIN a.categories c WHERE" +
            "(a.name LIKE %:article_name%) AND" +
            "(a.manufacturer.name LIKE %:article_manufacturer%) AND" +
            "(c.name LIKE %:article_category%)")
    Page<ArticleEntity> findByANameMNameCName(Pageable pageable,
                                              @Param("article_name") String articleName,
                                              @Param("article_manufacturer") String articleManufacturer,
                                              @Param("article_category") String articleCategory);

}
