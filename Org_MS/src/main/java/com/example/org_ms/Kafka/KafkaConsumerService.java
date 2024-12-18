package com.example.org_ms.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${organisation.topic.name}", groupId = "organisation-group")
    public void listen(String message) {
        System.out.println("Message reçu : " + message);
        // Logique métier pour traiter le message
    }
}

