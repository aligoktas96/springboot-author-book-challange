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

import com.example.authorApp.authorApp.Service.AdminService;
import com.example.authorApp.authorApp.Service.AuthorService;
import com.example.authorApp.authorApp.Service.BookService;
import com.example.authorApp.authorApp.entity.Author;
import com.example.authorApp.authorApp.entity.Book;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private AdminService adminService;
    private BookService bookService;
    private AuthorService authorService;

    @GetMapping(path = "/books")
    public ResponseEntity listAllBooks()
    {
        return new ResponseEntity<>(adminService.getBooks(), HttpStatus.OK);
    }

    @GetMapping(path = "/authors")
    public ResponseEntity listAllAuthors()
    {
        return new ResponseEntity<>(adminService.getAuthors(), HttpStatus.OK);
    }

    @PostMapping(path = "/books")
    public ResponseEntity addBook(@RequestBody Book book)
    {
        adminService.createBook(book);
        return new ResponseEntity<>("Book addition Success !!! ", HttpStatus.CREATED);
    }

    @PostMapping("/addAuthor")
    public ResponseEntity addAuthor(@RequestBody Author author)
    {
        authorService.createAuthor(author);
        return new ResponseEntity<>(adminService.getAuthors(), HttpStatus.CREATED);
    }

    @PutMapping(path = "/books")
    public ResponseEntity updateBook(@RequestBody Book book){
        adminService.updateBook(book.getId(),book);
        return new ResponseEntity<>(adminService.getAuthors(),HttpStatus.OK);
    }

    @DeleteMapping(path = "/books")
    public ResponseEntity deleteBook(@RequestBody Book book){
        adminService.deleteBook(book.getId());
        return  new ResponseEntity<>("Book deleted !!!", HttpStatus.OK);
    }

}
