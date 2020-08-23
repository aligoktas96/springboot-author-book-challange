package com.example.authorApp.authorApp.Service;

import java.util.List;

import com.example.authorApp.authorApp.entity.Book;

public interface AdminService
{
    void createBook(String id, String name,String authorName, String publicationYear, Book book);
    List<Book> getBooks();
    void updateBook(String id, Book book);
    void deleteBook(String id);
}