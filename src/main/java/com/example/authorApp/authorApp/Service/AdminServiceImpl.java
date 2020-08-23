package com.example.authorApp.authorApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authorApp.authorApp.entity.Author;
import com.example.authorApp.authorApp.entity.Book;
import com.example.authorApp.authorApp.repository.AuthorRepository;
import com.example.authorApp.authorApp.repository.BookRepository;

@Service
public class AdminServiceImpl implements AdminService
{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    @Autowired
    public AdminServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository)
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
        return bookRepository.findAll();

    }

    @Override
    public List<Author> getAuthors()
    {
        return authorRepository.findAll();
    }

    @Override
    public void updateBook(String id,Book book)
    {
        bookRepository.deleteById(id);
        bookRepository.save(book);

    }

    @Override
    public void deleteBook(String id)
    {
        bookRepository.deleteById(id);
    }

}