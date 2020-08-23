package com.example.authorApp.authorApp.Service;

import java.util.List;

import com.example.authorApp.authorApp.entity.Book;


public interface BookService
{
    void createBook(Book book);
    List<Book> getBooks();
    void updateBook(Book book);
    void deleteBook(String id);
}