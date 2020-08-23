package com.example.authorApp.authorApp.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "books")
public class Book
{
    @Id
    private String id;
    private String name;
    private String authorName;
    private String publicationYear;
}
