package com.pragma.StockMicroservice.domain.usecase.exception;

public class NoManufacturerNameBlankFieldException extends RuntimeException {
    public NoManufacturerNameBlankFieldException() {
        super("No blank field allowed in manufacturer name");
    }
}
