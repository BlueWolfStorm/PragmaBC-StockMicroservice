package com.pragma.StockMicroservice.domain.usecase.exception;

public class MaximumLimitExceededException extends RuntimeException {
    public MaximumLimitExceededException(int size) {
        super("Maximum limit exceeded: " + size + " chars");
    }

    public MaximumLimitExceededException(int start, int end) {
        super("Limit range exceeded: " + start + " to " + end + " elements");
    }
}
