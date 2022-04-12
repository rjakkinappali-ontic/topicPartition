package com.example.topicPartition.service;

import com.example.topicPartition.constants.ConstantValues;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(groupId = ConstantValues.groupId, topicPartitions = @TopicPartition(
            topic = ConstantValues.topicNameString,
            partitionOffsets = { @PartitionOffset(
                    partition = "0",
                    initialOffset = "0") }))
    public void listenerString(String data){
        System.out.println("Received partition 0:  "+ data);
    }
    @KafkaListener(groupId = ConstantValues.groupId, topicPartitions = @TopicPartition(
            topic = ConstantValues.topicNameString,
            partitionOffsets = { @PartitionOffset(
                    partition = "1",
                    initialOffset = "0") }))
    public void listenerString2(String data){
        System.out.println("Received partition 1:  "+ data);
    }
}
