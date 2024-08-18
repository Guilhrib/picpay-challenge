package com.ribeiro.picpaychallenge.notification;

import com.ribeiro.picpaychallenge.transaction.Transaction;

public interface NotificationService {

    void send(Transaction transaction);
}
