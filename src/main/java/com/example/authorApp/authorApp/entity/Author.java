package com.example.authorApp.authorApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "authors")
public class Author
{
    @Id
    private String id;
    private String name;
    private String bookCount;
}
