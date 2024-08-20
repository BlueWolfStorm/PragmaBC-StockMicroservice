package com.pragma.StockMicroservice.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ArticleResponse {
    private String name;
    private String description;
    private int quantity;
    private double price;
    private ManufacturerResponse manufacturer;
    private List<CategoryResponse> categories;
}
