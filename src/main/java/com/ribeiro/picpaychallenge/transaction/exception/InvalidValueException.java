package com.ribeiro.picpaychallenge.transaction.exception;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException() {
        super("Value must be higher than zero(0)");
    }
}
