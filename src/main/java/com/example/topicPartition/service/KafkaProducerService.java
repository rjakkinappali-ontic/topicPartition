package com.example.topicPartition.service;

import com.example.topicPartition.constants.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateString;

    public void sendMessage(String message) {
        this.kafkaTemplateString.send(ConstantValues.topicNameString, message);
    }
}
