package com.example.authorApp.authorApp.Service;

import java.util.List;

import com.example.authorApp.authorApp.entity.Author;
import com.example.authorApp.authorApp.entity.Book;

public interface AdminService
{
    void createBook(Book book);
    List<Book> getBooks();
    List<Author> getAuthors();
    void updateBook(String id, Book book);
    void deleteBook(String id);
}