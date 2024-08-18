package com.ribeiro.picpaychallenge.authorization;

import com.ribeiro.picpaychallenge.authorization.exception.UnauthorizedTransactionException;
import com.ribeiro.picpaychallenge.transaction.Transaction;

public interface AuthorizerService {

    void authorize(Transaction transaction) throws UnauthorizedTransactionException;
}
