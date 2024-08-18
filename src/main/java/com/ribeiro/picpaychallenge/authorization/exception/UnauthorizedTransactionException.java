package com.ribeiro.picpaychallenge.authorization.exception;

public class UnauthorizedTransactionException extends RuntimeException {
    public UnauthorizedTransactionException() {
        super("Unauthorized transaction");
    }
}
