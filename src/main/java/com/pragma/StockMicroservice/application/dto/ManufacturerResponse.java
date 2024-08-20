package com.pragma.StockMicroservice.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManufacturerResponse {
    private String name;
    private String description;
}
