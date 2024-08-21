package com.pragma.StockMicroservice.application.dto.manufacturer;

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
