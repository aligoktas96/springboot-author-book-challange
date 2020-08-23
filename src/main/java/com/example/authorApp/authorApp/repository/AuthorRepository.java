package com.example.authorApp.authorApp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.authorApp.authorApp.entity.Author;


public interface AuthorRepository extends MongoRepository<Author,String>
{
    void deleteByName(String authorName);
    List<Author> findAuthorsByName(String authorName);
}
