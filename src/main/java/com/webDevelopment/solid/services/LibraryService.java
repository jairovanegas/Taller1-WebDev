package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;

import java.util.List;

public interface LibraryService {
    public Book addToLibrary(Book book) throws Exception;
    public List<Book> getAuthorBooks(String author) throws Exception;
    public String bookDetails(String title) throws Exception;
}
