package com.springBootTutoriol.devtiro.repositories.impl;

import com.springBootTutoriol.devtiro.entites.Author;
import com.springBootTutoriol.devtiro.repositories.IAuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
    public void updateAuthorAge(Author author) {
        Session session = entityManager.unwrap(Session.class);
        Query updateAuthorAgeQuery = session.createQuery("UPDATE Author SET age = :newAge WHERE id = :authorId");
        updateAuthorAgeQuery.setParameter("authorId", author.getId());
        updateAuthorAgeQuery.setParameter("newAge", author.getAge());
        updateAuthorAgeQuery.executeUpdate();
    }

    @Override
    public void updateAuthorName(Author author) {
        Session session = entityManager.unwrap(Session.class);
        Query updateAuthorNameQuery = session.createQuery("UPDATE Author SET name = :newName WHERE id = :authorId");
        updateAuthorNameQuery.setParameter("authorId" , author.getId());
        updateAuthorNameQuery.setParameter("newName" , author.getName());
        updateAuthorNameQuery.executeUpdate();
    }

    @Override
    public void deleteAuthor(Author author) {
        Session session = entityManager.unwrap(Session.class);
        Author authorToDelete = session.get(Author.class, author.getId());
        session.remove(authorToDelete);
    }
}
