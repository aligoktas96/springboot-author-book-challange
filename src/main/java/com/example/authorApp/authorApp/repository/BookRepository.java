package com.example.authorApp.authorApp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.authorApp.authorApp.entity.Book;

public interface BookRepository extends MongoRepository<Book,String>
{
    List<Book> findByAuthorName(String authorName);
}
