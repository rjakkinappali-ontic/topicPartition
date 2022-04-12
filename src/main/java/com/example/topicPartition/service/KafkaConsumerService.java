package com.example.topicPartition.service;

import com.example.topicPartition.constants.ConstantValues;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = ConstantValues.topicNameString, groupId = ConstantValues.groupId)
    public void listenerString(String data){
        System.out.println("Received partition 0:  "+ data);
    }
    @KafkaListener(topics = ConstantValues.topicNameString, groupId = ConstantValues.groupId)
    public void listenerString2(String data){
        System.out.println("Received partition 1:  "+ data);
    }
}
