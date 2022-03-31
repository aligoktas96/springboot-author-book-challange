package com.example.authorApp.authorApp.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.authorApp.authorApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.authorApp.authorApp.entity.Book;
import com.example.authorApp.authorApp.repository.AuthorRepository;
import com.example.authorApp.authorApp.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService
{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository)
    {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void createBook(Book book)
    {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks()
    {
        return bookRepository.findByAuthorName(whoAmI().getUsername());
    }

    @Override
    public void updateBook(Book book)
    {
        Optional<Book> optionalBook = this.bookRepository.findByIdAndAuthorName(book.getId(),
                whoAmI().getUsername());

        if(optionalBook.isPresent()){
            book.setAuthorName(whoAmI().getUsername());
            System.out.println(book);
            this.bookRepository.save(book);
        }else {
            // Olumsuz
            System.err.println("ERROR");
        }
    }

    @Override
    public void deleteBook(String id)
    {
        bookRepository.deleteById(id);
    }

    private User whoAmI()
    {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
