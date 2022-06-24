package com.training.collections.set.GenericHashSet;

public class DuplicatedElementException extends RuntimeException {
    public DuplicatedElementException(String errorMessage) {
        super("Duplicated element " + errorMessage);
    }
}
