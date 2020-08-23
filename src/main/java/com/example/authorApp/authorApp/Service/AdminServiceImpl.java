package com.example.authorApp.authorApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.authorApp.authorApp.entity.Book;
import com.example.authorApp.authorApp.repository.AuthorRepository;
import com.example.authorApp.authorApp.repository.BookRepository;

@Service
public class AdminServiceImpl implements AdminService
{

    private final BookRepository bookRepository;

    @Autowired
    public AdminServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository)
    {
        this.bookRepository = bookRepository;

    }

    @Override
    public void createBook(String id , String name, String authorName , String publicationYear, Book book)
    {
        book.setId(id);
        book.setName(name);
        book.setAuthorName(authorName);
        book.setPublicationYear(publicationYear);
        bookRepository.save(book);
    }
    @Override
    public List<Book> getBooks()
    {
        return bookRepository.findAll();

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