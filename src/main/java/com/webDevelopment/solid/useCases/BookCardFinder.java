package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.Formatter;
import com.webDevelopment.solid.services.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCardFinder {

    private final Book book;
    private Formatter formatter;
    private Sender sender;

    @Autowired
    public BookCardFinder(Formatter formatter, Sender sender) {
        this.formatter = formatter;
        this.sender = sender;
        book = new Book("1984", "George Orwell", "Distopia", 1949, 9000, 400);
    }

    public String execute() {
        String formattedText = formatter.Format(book.createBookCard());
        if (sender.sender(formattedText)) {
            return formattedText;
        }
        return "ERROR";
    }
}
