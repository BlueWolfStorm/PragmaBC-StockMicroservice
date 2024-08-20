package com.pragma.StockMicroservice.infrastructure.output.jimmer.entity;

import org.babyfish.jimmer.sql.*;

import java.util.List;

@Entity
@Table(name = "ARTICLE")
public interface ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    String name();
    String description();
    int quantity();
    double price();

    @ManyToOne
    ManufacturerEntity manufacturer();

    @ManyToMany
    @JoinTable(name = "ARTICLE_CATEGORY",
            joinColumns = @JoinColumn(name = "ARTICLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    List<CategoryEntity> categories();
}
