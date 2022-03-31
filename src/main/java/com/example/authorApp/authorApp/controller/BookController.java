package com.example.authorApp.authorApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authorApp.authorApp.service.BookService;
import com.example.authorApp.authorApp.entity.Book;

@RestController
@RequestMapping("/books")
public class BookController
{

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity listAll()
    {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book)
    {
        bookService.createBook(book);
        return new ResponseEntity<>("Book addition Success !!! ", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateBook(@RequestBody Book book)
    {
        bookService.updateBook(book);
        return new ResponseEntity<>("Book update Success !!!", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteBook(@RequestBody Book book)
    {
        bookService.deleteBook(book.getId());
        return new ResponseEntity<>("Book deleted !!!", HttpStatus.OK);
    }

}
