package com.training.collections.exceptions;

public class DuplicatedElementException extends RuntimeException {
    public DuplicatedElementException(String errorMessage) {
        super("Duplicated element " + errorMessage);
    }
}
