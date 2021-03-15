package com.webDevelopment.solid.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Sender {
    Boolean sender(String message);
//    Boolean senderSlack(String notification, List<String> emails);
}
