package com.springBootTutoriol.devtiro.controllers;

import com.springBootTutoriol.devtiro.entites.Author;
import com.springBootTutoriol.devtiro.repositories.IAuthorRepository;
import com.springBootTutoriol.devtiro.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private IAuthorService authorService;

    @Autowired
    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return this.authorService.getAuthors();
    }

    @PostMapping("/add-author")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }


}
