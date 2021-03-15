package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {
    private LibraryService library;

    @Autowired
    public LibraryController(LibraryService library) {
        this.library = library;
    }

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(Exception e){
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> createBook(@RequestBody Book book) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(this.library.addToLibrary(book));
    }

    @GetMapping(value = "/author/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> authorShelf(@PathVariable String author) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(library.getAuthorBooks(author));
    }

    @GetMapping(value = "/book/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> bookDetails(@PathVariable String title) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(library.bookDetails(title));
    }
}
