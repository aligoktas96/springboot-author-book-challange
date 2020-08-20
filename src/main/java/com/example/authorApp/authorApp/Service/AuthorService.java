package com.example.authorApp.authorApp.Service;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.authorApp.authorApp.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorService
{

    @Autowired
    private AuthorRepository authorRepository;

    @PostConstruct
    public void init(){

    }

    @GetMapping
    public ResponseEntity<List> listAll(){
        return ResponseEntity.ok(authorRepository.findAll());
    }


}
