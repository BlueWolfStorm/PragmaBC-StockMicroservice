package com.pragma.StockMicroservice.application.dto;

import com.pragma.StockMicroservice.domain.model.Category;
import com.pragma.StockMicroservice.domain.model.Manufacturer;
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
