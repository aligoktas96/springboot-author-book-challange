package com.example.authorApp.authorApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.authorApp.authorApp.entity.Author;
import com.example.authorApp.authorApp.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService
{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(Author author)
    {
        authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthors()
    {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAuthorsByName(Author author)
    {
        return authorRepository.findAuthorsByName(author.getName());
    }

    @Override
    public void updateAuthorName(Author author)
    {
            author.setName(author.getName());
            authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(String id)
    {
        if (whoAmI().getUsername().equals("admin"))
        {
            authorRepository.deleteById(id);
        }
    }

    private User whoAmI(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
