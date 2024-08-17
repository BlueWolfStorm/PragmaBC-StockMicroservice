package com.pragma.StockMicroservice.domain.usecase.exception;

public class NoCategoryNameBlankFieldException extends RuntimeException {
    public NoCategoryNameBlankFieldException() {
        super("No blank field allowed in category name");
    }
}
