package com.springBootTutoriol.devtiro.services;

import com.springBootTutoriol.devtiro.entites.Author;

import java.util.List;

public interface IAuthorService {

    List<Author> getAuthors();

    Author getAuthorById(int authorId);

    void addAuthor(Author author);

    void updateAuthor(Author author);

    void updateAuthorAge(Author author);

    void updateAuthorName(Author author);

    void deleteAuthor(Author author);

}
