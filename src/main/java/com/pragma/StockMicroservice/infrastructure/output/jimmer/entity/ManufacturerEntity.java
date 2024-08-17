package com.pragma.StockMicroservice.infrastructure.output.jimmer.entity;

import org.babyfish.jimmer.sql.*;

@Entity
@Table(name = "MANUFACTURER")
public interface ManufacturerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    @Key
    String name();
    String description();
}
