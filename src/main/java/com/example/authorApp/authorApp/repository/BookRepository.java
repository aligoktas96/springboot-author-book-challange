package com.example.authorApp.authorApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.authorApp.authorApp.entity.Book;

public interface BookRepository extends MongoRepository<Book, String>
{
    Optional<Book> findByIdAndAuthorName(String id, String authorName);

    List<Book> findByAuthorName(String authorName);

    void deleteByAuthorName(String id);
}
