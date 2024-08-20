package com.pragma.StockMicroservice.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Article {
    private long id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private Manufacturer manufacturer;
    private List<Category> categories;
}
