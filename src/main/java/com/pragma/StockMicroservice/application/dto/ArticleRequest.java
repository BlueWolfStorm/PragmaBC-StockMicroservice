package com.pragma.StockMicroservice.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ArticleRequest {
    private String name;
    private String description;
    private int quantity;
    private double price;
    private ManufacturerRequest manufacturer;
    private List<CategoryRequest> categories;
}
