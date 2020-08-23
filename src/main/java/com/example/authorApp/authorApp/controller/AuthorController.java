package com.example.authorApp.authorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authorApp.authorApp.Service.AuthorService;
import com.example.authorApp.authorApp.Service.BookService;
import com.example.authorApp.authorApp.entity.Author;

@RestController
@RequestMapping("/authors")
public class AuthorController
{
    @Autowired
    private AuthorService authorService;
    private BookService bookService;

    @GetMapping
    public ResponseEntity listAll()
    {
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateAuthor(@RequestBody Author author)
    {
        authorService.updateAuthorName(author);
        return new ResponseEntity<>(authorService.getAuthorsByName(author), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteAuthor(@RequestBody Author author)
    {
        authorService.deleteAuthor(author.getId());
        return new ResponseEntity<>(authorService.getAuthorsByName(author), HttpStatus.OK);
    }
}
