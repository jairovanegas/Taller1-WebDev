package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.services.RaleyEmailSender;
import com.webDevelopment.solid.services.XMLFormatter;
import com.webDevelopment.solid.useCases.BookCardFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindBookCardController {

    private BookCardFinder bookCardFinder;

    @Autowired
    public FindBookCardController(BookCardFinder bookCardFinder) {
        this.bookCardFinder = bookCardFinder;
    }

    @RequestMapping("/healthCheck")
    public String healthCkeck() {
        return "Server up";
    }

    @RequestMapping("/bookCardFinder")
    public String findBookCard() {
        return bookCardFinder.execute();
    }
}
