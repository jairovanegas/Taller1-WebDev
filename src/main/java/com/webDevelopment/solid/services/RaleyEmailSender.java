package com.webDevelopment.solid.services;

import org.springframework.stereotype.Service;

import java.util.List;

public class RaleyEmailSender implements Sender {

    private String userEmail;

//    public RaleyEmailSender(String userEmail) {
//        this.userEmail = userEmail;
//    }

    private void SendEmail(String message) {
        //TODO: Enviar Correo
    }

    @Override
    public Boolean sender(String message) {
        this.SendEmail("email: " + message);
        return true;
    }

//    @Override
//    public Boolean senderSlack(String notification, List<String> emails) {
//        return false;
//    }
}
