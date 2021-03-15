package com.webDevelopment.solid.models;

public class Book {
    private String title;
    private String author;
    private String description;
    private Integer publishedYear;
    private Integer price;
    private Integer pageNumber;

    public Book(String title, String author, String description, Integer publishedYear, Integer price, Integer pageNumber) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishedYear = publishedYear;
        this.price = price;
        this.pageNumber = pageNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public String createBookCard()
    {
        return "The book " + this.title + " has benn written by " + this.author + " and was " +
                "published in " + this.publishedYear + ". The book's price is " + this.price;
    }
}
