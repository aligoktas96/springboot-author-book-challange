package com.example.authorApp.authorApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.authorApp.authorApp.entity.Book;

public interface BookRepository extends MongoRepository<Book,String>
{
}
