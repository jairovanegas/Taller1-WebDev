package com.webDevelopment.solid.services;

public class HTMLFormatter implements Formatter{

    @Override
    public String Format(String message) {
        return "<p>" + message + "</p>";
    }
}
