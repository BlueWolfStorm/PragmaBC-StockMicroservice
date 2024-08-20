package com.pragma.StockMicroservice.infrastructure.exception;

public class NoManufacturerFoundException extends RuntimeException {
    public NoManufacturerFoundException(String name) {
        super("No Manufacturer found with name: " + name);
    }
}
