package com.springBootTutoriol.devtiro.controllers;

import com.springBootTutoriol.devtiro.entites.Author;
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

    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return this.authorService.getAuthorById(id);
    }

    @PostMapping("/add-author")
    public void addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @PostMapping("/update-author")
    public void updateAuthor(@RequestBody Author author) {
        this.authorService.updateAuthor(author);
    }

    @PatchMapping("update-author-age")
    public void patchUpdateAuthor(@RequestBody Author author) {
        this.authorService.updateAuthorAge(author);
    }

    @PostMapping("/delete-author")
    public void deleteAuthor(@RequestBody Author author) {
        this.authorService.deleteAuthor(author);
    }


}
