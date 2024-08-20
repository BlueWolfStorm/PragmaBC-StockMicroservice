package com.pragma.StockMicroservice.domain.usecase.exception;

public class NoCategoriesRepeated extends RuntimeException {
    public NoCategoriesRepeated() {
        super("No categories can be repeated");
    }
}
