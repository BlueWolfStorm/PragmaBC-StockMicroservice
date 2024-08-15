package com.pragma.StockMicroservice.domain;

import org.babyfish.jimmer.sql.*;

@Entity
public interface Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    @Key()
    String nombre();

    String descripcion();
}
