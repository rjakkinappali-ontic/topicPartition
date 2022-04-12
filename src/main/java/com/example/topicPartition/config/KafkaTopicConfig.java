package com.example.topicPartition.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaTopicConfig {
    @Bean
    public NewTopic kafkaStringTopicBuilder(){
        return TopicBuilder.name("testing")
                .partitions(2)
                .replicas(1)
                .build();
    }
}
