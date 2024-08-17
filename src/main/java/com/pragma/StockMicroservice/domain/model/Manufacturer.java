package com.pragma.StockMicroservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Manufacturer {
    private long id;
    private String name;
    private String description;
}
