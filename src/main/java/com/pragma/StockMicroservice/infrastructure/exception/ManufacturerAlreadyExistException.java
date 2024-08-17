package com.pragma.StockMicroservice.infrastructure.exception;

public class ManufacturerAlreadyExistException extends RuntimeException {
    public ManufacturerAlreadyExistException() {
        super("Manufacturer already exist");
    }
}
