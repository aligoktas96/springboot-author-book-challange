package com.example.authorApp.authorApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    public void createBook(String id , String name,String authorName ,String publicationYear,Book book)
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
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return bookRepository.findByAuthorName(principal.getUsername());
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
