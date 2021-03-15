package com.webDevelopment.solid.services;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NRS360EmailSender implements Sender{

    @Override
    public Boolean sender(String message) {
        if(message.length() <= 200){
            //TODO: Lógica para NRS360
            return true;
        }else{
            System.out.printf("%s:ERROR el mensaje supera por %d caracteres el limite permitido%n", this.getClass().getSimpleName(), message.length()-200);
            return false;
        }
    }

//    @Override
//    public Boolean senderSlack(String notification, List<String> emails) {
//        return false;
//    }
}
