package com.pragma.StockMicroservice.application.dto.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryResponse {
    private String name;
    private String description;
}
