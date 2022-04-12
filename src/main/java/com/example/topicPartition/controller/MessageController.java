package com.example.topicPartition.controller;

import com.example.topicPartition.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trial")
public class MessageController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/publishString")
    public void publishString(@RequestParam(value = "message") String message){
        kafkaProducerService.sendMessage(message);
    }
}
