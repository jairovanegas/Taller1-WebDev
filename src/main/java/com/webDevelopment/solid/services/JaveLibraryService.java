package com.webDevelopment.solid.services;

import com.webDevelopment.solid.DB.DB;
import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class JaveLibraryService implements LibraryService {

    @Override
    public Book addToLibrary(Book book) throws Exception {
        this.verifyTitle(book.getTitle());
        this.verifyAuthor(book.getAuthor());
        this.verifyDescription(book.getDescription());
        this.verifyPublishedYear(book.getPublishedYear());
        this.verifyPrice(book.getPrice());
        this.verifyPageNumber(book.getPageNumber());
        DB.getInstance().addBook(book.getAuthor(), book);
        return book;
    }

    private void verifyTitle(String title) throws Exception {
        if (title.length() < 5 || title.length() > 100) {
            throw new Exception("Field title does not meet valid length criteria, title must be within 5 to 100 characters");
        }
    }

    private void verifyDescription(String description) throws Exception {
        if (description.length() > 200) {
            throw new Exception("Field description does not meet valid length criteria, description must be less than 200 characters");
        }
    }

    private void verifyPrice(Integer price) throws Exception {
        if (price < 10000) {
            throw new Exception("Field price does not meet valid value criteria, price must be greater than 10.000 with no cents");
        }
    }

    private void verifyAuthor(String author) throws Exception {
        Pattern fullName = Pattern.compile("^([A-Z][a-z]*(\\s))+[A-Z][a-z]*$");
        if (!fullName.matcher(author).find()) {
            throw new Exception("Field author does not meet valid format criteria, valid format example 'Pepe Perez'");
        }
    }

    private void verifyPublishedYear(Integer publishedYear) throws Exception {
        if (publishedYear < 1000) {
            throw new Exception("Field publishedYear does not meet valid value criteria, library can't hold pre 1000 year books");
        }
        int thisYear = LocalDate.now().getYear();
        if (publishedYear > thisYear) {
            throw new Exception("Field publishedYear does not meet valid value criteria, received year is in the future");
        }
    }

    private void verifyPageNumber(Integer pageNumber) throws Exception {
        if (pageNumber < 1 || pageNumber > 1500) {
            throw new Exception("Field pageNumber does not meet valid value criteria, pageNumber must be within 1 to 1500 pages");
        }
    }

    @Override
    public List<Book> getAuthorBooks(String author) throws Exception {
        verifyAuthor(author);
        verifyAuthorExistence(author);
        return DB.getInstance().getAuthorShelf(author);
    }

    public void verifyAuthorExistence(String author) throws Exception{
        if(DB.getInstance().getAuthorShelf(author) == null){
            throw new Exception("There is not a book in this library written by that author");
        }
    }

    @Override
    public String bookDetails(String title) throws Exception {
        verifyTitle(title);
        Book book = DB.getInstance().getBook(title);
        if(book == null){
            throw new Exception("There is not a book in this library with that title");
        }
        return String.format("Book Description: %s, Price: %d, Published Year: %d, Number of Pages: %d",
                book.getDescription(), book.getPrice(), book.getPublishedYear(), book.getPageNumber());
    }
}
