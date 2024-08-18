package com.ribeiro.picpaychallenge.notification;

import com.ribeiro.picpaychallenge.transaction.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.ribeiro.picpaychallenge.config.KafkaConfig.NOTIFICATION_TOPIC;

@Service
@AllArgsConstructor
public class NotificationProducer {
    private final KafkaTemplate<String, Transaction> template;

    public void sendNotification(Transaction transaction) {
        template.send(NOTIFICATION_TOPIC, transaction);
    }
}
