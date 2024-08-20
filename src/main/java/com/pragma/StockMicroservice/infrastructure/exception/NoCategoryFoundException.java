package com.pragma.StockMicroservice.infrastructure.exception;

public class NoCategoryFoundException extends RuntimeException {
    public NoCategoryFoundException(String name) {
        super("No category found with name: " + name);
    }
}
