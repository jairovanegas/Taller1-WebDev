package com.webDevelopment.solid.services;

import org.springframework.stereotype.Service;


public class XMLFormatter implements Formatter{
    @Override
    public String Format(String message) {
        return "<element att='bookCard'>" + message + "</element>" ;
    }
}
