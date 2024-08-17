package com.pragma.StockMicroservice.domain.usecase.exception;

public class MaximumLimitExceededException extends RuntimeException {
    public MaximumLimitExceededException(int size) {
        super("Maximum limit exceeded: " + size + " chars");
    }
}
