package com.pragma.StockMicroservice.infrastructure.exception;

public class NoArticleFoundException extends RuntimeException {
    public NoArticleFoundException(String name) {
        super("No Article found with name: " + name);
    }
}
