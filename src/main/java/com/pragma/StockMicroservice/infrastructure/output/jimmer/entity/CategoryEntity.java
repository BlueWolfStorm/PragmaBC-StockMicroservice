package com.pragma.StockMicroservice.infrastructure.output.jimmer.entity;

import org.babyfish.jimmer.sql.*;

@Entity
@Table(name = "CATEGORY")
public interface CategoryEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    @Key
    String name();

    String description();
}
