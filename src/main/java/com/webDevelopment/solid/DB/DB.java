package com.webDevelopment.solid.DB;

import com.webDevelopment.solid.models.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB {
    private static DB instance;
    private Map<String, List<Book>> store;
    private Map<String, Book> index;

    private DB() {
        this.store = new HashMap<>();
        this.index = new HashMap<>();
    }

    public static DB getInstance() {
        if(instance == null){
            DB.instance = new DB();
        }
        return instance;
    }

    public void addBook(String author, Book book){
        if(!this.store.containsKey(author)){
            this.store.put(author, new ArrayList<>());
        }
        this.store.get(author).add(book);
        this.index.put(book.getTitle(), book);
    }

    public List<Book> getAuthorShelf(String author){
        return this.store.get(author);
    }

    public Book getBook(String title){
        return this.index.get(title);
    }

}
