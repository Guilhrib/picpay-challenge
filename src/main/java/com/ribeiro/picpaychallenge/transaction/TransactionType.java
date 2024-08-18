package com.ribeiro.picpaychallenge.transaction;

import lombok.Getter;

@Getter
public enum TransactionType {
    PAYER("Transaction payer"),
    PAYEE("Transaction payee");

    private final String description;

    TransactionType(String description) {
        this.description = description;
    }
}
