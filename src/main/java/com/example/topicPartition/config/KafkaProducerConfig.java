package com.example.topicPartition.config;

import com.example.topicPartition.constants.ConstantValues;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    private String bootstrapServers = ConstantValues.bootstrapServers;


    public Map<String, Object> producerConfig(Object keySerializer, Object valueSerializer){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        return props;
    }

    @Bean
    public ProducerFactory<String, String> producerFactoryString(){
        return new DefaultKafkaProducerFactory<>(producerConfig(StringSerializer.class, StringSerializer.class));
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplateString(){
        return new KafkaTemplate<>(producerFactoryString());
    }
}
