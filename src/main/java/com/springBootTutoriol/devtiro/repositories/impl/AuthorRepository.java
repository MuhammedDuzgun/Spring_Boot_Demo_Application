package com.springBootTutoriol.devtiro.repositories.impl;

import com.springBootTutoriol.devtiro.entites.Author;
import com.springBootTutoriol.devtiro.repositories.IAuthorRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository implements IAuthorRepository {

    private EntityManager entityManager;

    @Autowired
    public AuthorRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Author> getAuthors() {
        Session session = entityManager.unwrap(Session.class);
        List<Author> authorList = session.createQuery("from Author", Author.class).getResultList();
        return authorList;
    }

    @Override
    public Author getAuthorById(int authorId) {
        Session session = entityManager.unwrap(Session.class);
        Author author = session.get(Author.class, authorId);
        return author;
    }

    @Override
    public void addAuthor(Author author) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(author);
    }

    @Override
    public void updateAuthor(Author author) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        Session session = entityManager.unwrap(Session.class);
        Author authorToDelete = session.get(Author.class, author.getId());
        session.remove(authorToDelete);
    }
}
