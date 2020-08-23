package com.example.authorApp.authorApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Document(collection = "authors")
public class Author
{
    @Id
    private String id;
    @NotNull
    private String name;
    private String bookName;
}
