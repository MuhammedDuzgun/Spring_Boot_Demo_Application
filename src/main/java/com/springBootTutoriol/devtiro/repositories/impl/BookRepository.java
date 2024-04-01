package com.springBootTutoriol.devtiro.repositories.impl;

import com.springBootTutoriol.devtiro.entites.Book;
import com.springBootTutoriol.devtiro.repositories.IBookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
    public void updateBookTitle(Book book) {
        Session session = entityManager.unwrap(Session.class);
        Query updateBookTitleQuery = session.createQuery("UPDATE Book SET title = :newTitle WHERE id = :bookId");
        updateBookTitleQuery.setParameter("newTitle", book.getTitle());
        updateBookTitleQuery.setParameter("bookId", book.getId());
        updateBookTitleQuery.executeUpdate();
    }

    @Override
    public void updateBookAuthorName(Book book) {
        Session session = entityManager.unwrap(Session.class);
        Query updateBookAuthorName = session.createQuery("UPDATE Book SET authorName = :newAuthorName WHERE id = :bookId");
        updateBookAuthorName.setParameter("newAuthorName", book.getAuthorName());
        updateBookAuthorName.setParameter("bookId" , book.getId());
        updateBookAuthorName.executeUpdate();
    }

    @Override
    public void deleteBook(Book book) {
        Session session = entityManager.unwrap(Session.class);
        Book bookToDelete = session.get(Book.class, book.getId());
        session.remove(bookToDelete);
    }
}
