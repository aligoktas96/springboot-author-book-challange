package com.example.authorApp.authorApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.authorApp.authorApp.entity.Author;

public interface AuthorRepository extends MongoRepository<Author,String>
{

}
