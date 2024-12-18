package com.example.donation.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendDonationMessage(String message) {
        jmsTemplate.convertAndSend("charity.donation.queue", message);
        System.out.println("Message sent: " + message);
    }
}
