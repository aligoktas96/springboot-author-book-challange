package com.example.authorApp.authorApp.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Document(collection = "books")
public class Book
{
    @Id
    private String id;
    private String name;
    private String publicationYear;
}
