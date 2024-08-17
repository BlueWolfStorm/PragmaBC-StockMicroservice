package com.pragma.StockMicroservice.infrastructure.exception;

public class CategoryAlreadyExistException extends RuntimeException {
    public CategoryAlreadyExistException() {
        super("Category already exist");
    }
}
