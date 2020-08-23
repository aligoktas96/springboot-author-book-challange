package com.example.authorApp.authorApp;

import java.security.Provider.Service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class AuthorAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorAppApplication.class, args);
	}





}
