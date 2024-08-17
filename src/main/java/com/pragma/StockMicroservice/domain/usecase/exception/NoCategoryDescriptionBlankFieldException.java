package com.pragma.StockMicroservice.domain.usecase.exception;

public class NoCategoryDescriptionBlankFieldException extends RuntimeException {
    public NoCategoryDescriptionBlankFieldException() {
        super("No blank field allowed in category description");
    }
}
