package com.webDevelopment.solid.services;

import java.util.List;

public class SlackSender implements Sender{
    @Override
    public Boolean sender(String message) {
        return false;
    }

//    @Override
//    public Boolean senderSlack(String notification, List<String> emails) {
//        //TODO: Notificación Slack Lógica
//        return true;
//    }
}
