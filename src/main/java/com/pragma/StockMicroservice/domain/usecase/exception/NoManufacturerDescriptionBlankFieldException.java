package com.pragma.StockMicroservice.domain.usecase.exception;

public class NoManufacturerDescriptionBlankFieldException extends RuntimeException {
    public NoManufacturerDescriptionBlankFieldException() {
        super("No blank field allowed in category description");
    }
}
