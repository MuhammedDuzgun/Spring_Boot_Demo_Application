package com.springBootTutoriol.devtiro.services.impl;

import com.springBootTutoriol.devtiro.entites.Author;
import com.springBootTutoriol.devtiro.repositories.IAuthorRepository;
import com.springBootTutoriol.devtiro.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    private IAuthorRepository authorRepository;

    @Autowired
    public AuthorService(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional
    public List<Author> getAuthors() {
        return this.authorRepository.getAuthors();
    }

    @Override
    @Transactional
    public Author getAuthorById(int authorId) {
        Author author = this.authorRepository.getAuthorById(authorId);
        return author;
    }

    @Override
    @Transactional
    public void addAuthor(Author author) {
        this.authorRepository.addAuthor(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        this.authorRepository.updateAuthor(author);
    }

    @Override
    @Transactional
    public void deleteAuthor(Author author) {
        this.authorRepository.deleteAuthor(author);
    }
}
