package com.example.authorApp.authorApp.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "authors")
public class Author
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    private String name;
    private String bookCount;
}
