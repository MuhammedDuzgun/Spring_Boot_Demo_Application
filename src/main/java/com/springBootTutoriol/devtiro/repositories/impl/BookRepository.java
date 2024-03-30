package com.springBootTutoriol.devtiro.repositories.impl;

import com.springBootTutoriol.devtiro.entites.Book;
import com.springBootTutoriol.devtiro.repositories.IBookRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements IBookRepository {

    private EntityManager entityManager;

    @Autowired
    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> getBooks() {
        Session session = entityManager.unwrap(Session.class);
        List<Book> bookList = session.createQuery("from Book" , Book.class).getResultList();
        return bookList;
    }

    @Override
    public Book getBookById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Book book = session.get(Book.class , id);
        return book;
    }

    @Override
    public void addBook(Book book) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(book);
    }

    @Override
    public void deleteBook(Book book) {
        Session session = entityManager.unwrap(Session.class);
        Book bookToDelete = session.get(Book.class, book.getId());
        session.remove(bookToDelete);
    }
}
