package com.ribeiro.picpaychallenge.notification;

import com.ribeiro.picpaychallenge.transaction.Transaction;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService{
    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);
    private final NotificationProducer producer;

    @Override
    public void send(Transaction transaction) {
        logger.info("publishing notification on topic with transaction: {}", transaction);
        producer.sendNotification(transaction);
        logger.info("notification published on topic with transaction: {}", transaction);
    }
}
