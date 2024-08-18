package com.ribeiro.picpaychallenge.notification;

import com.ribeiro.picpaychallenge.notification.exception.NotificationException;
import com.ribeiro.picpaychallenge.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;

import static com.ribeiro.picpaychallenge.config.KafkaConfig.NOTIFICATION_TOPIC;

@Service
public class NotificationConsumer {
    private final RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(NotificationConsumer.class);

    public NotificationConsumer(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
                .build();
    }

    @KafkaListener(topics = NOTIFICATION_TOPIC, groupId = "picpay-challenge")
    public void receiveNotification(Transaction transaction) {
        logger.info("receiving notification from topic, with transaction: {}", transaction);
        var response = restClient.get()
                .retrieve()
                .toEntity(Notification.class);

        if(response.getStatusCode().isError() || !Objects.requireNonNull(response.getBody()).message()) {
            throw new NotificationException();
        }
        logger.info("notification sent, with transaction: {}", transaction);
    }
}
