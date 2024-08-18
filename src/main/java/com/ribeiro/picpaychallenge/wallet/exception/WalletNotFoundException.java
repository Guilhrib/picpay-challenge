package com.ribeiro.picpaychallenge.wallet.exception;

import com.ribeiro.picpaychallenge.transaction.TransactionType;

public class WalletNotFoundException extends RuntimeException{
    public WalletNotFoundException(TransactionType owner) {
        super("Wallet of %s not found".formatted(owner.getDescription()));
    }
}
