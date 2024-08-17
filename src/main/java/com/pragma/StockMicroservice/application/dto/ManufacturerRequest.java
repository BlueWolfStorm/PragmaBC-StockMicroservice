package com.pragma.StockMicroservice.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManufacturerRequest {
    private String name;
    private String description;
}
