package com.ribeiro.picpaychallenge.transaction.exception;

public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(Object transaction) {
        super("Invalid transaction - %s".formatted(transaction));
    }
}
