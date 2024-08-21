package com.pragma.StockMicroservice.application.dto.article;

import com.pragma.StockMicroservice.application.dto.category.CategoryResponse;
import com.pragma.StockMicroservice.application.dto.manufacturer.ManufacturerResponse;
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
