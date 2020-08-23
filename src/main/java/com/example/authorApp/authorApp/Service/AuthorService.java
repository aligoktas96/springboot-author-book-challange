package com.example.authorApp.authorApp.Service;

import java.util.List;

import com.example.authorApp.authorApp.entity.Author;


public interface AuthorService
{
    void createAuthor(Author author);
    List<Author> getAuthors();
    List<Author> getAuthorsByName(Author author);
    void updateAuthorName(Author author);
    void deleteAuthor(String id);

}