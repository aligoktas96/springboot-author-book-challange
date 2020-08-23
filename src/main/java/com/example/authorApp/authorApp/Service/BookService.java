package com.example.authorApp.authorApp.Service;

import java.util.Collection;
import java.util.List;

import com.example.authorApp.authorApp.entity.Book;


public interface BookService
{
    void createBook(String id, String name,String authorName, String publicationYear, Book book);
    List<Book> getBooks();
    void updateBook(String id, Book book);
    void deleteBook(String id);
}