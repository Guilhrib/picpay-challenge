package com.ribeiro.picpaychallenge.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    public static final String NOTIFICATION_TOPIC = "transaction-notification";

    @Bean
    NewTopic notificationTopic() {
        return TopicBuilder.name(NOTIFICATION_TOPIC)
                .build();
    }
}
