package com.springBootTutoriol.devtiro.repositories;

import com.springBootTutoriol.devtiro.entites.Author;

import java.util.List;

public interface IAuthorRepository {

    List<Author> getAuthors();

    Author getAuthorById(int authorId);

    void addAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(Author author);

}
