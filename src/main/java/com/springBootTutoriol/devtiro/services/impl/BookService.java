package com.springBootTutoriol.devtiro.services.impl;

import com.springBootTutoriol.devtiro.entites.Book;
import com.springBootTutoriol.devtiro.repositories.IBookRepository;
import com.springBootTutoriol.devtiro.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService implements IBookService {

    private IBookRepository bookRepository;

    @Autowired
    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public List<Book> getBooks() {
        return this.bookRepository.getBooks();
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        Book book = this.bookRepository.getBookById(id);
        return book;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookRepository.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookRepository.updateBook(book);
    }

    @Override
    @Transactional
    public void updateBookTitle(Book book) {
        this.bookRepository.updateBookTitle(book);
    }

    @Override
    @Transactional
    public void updateBookAuthorName(Book book) {
        this.bookRepository.updateBookAuthorName(book);
    }

    @Override
    @Transactional
    public void deleteBook(Book book) {
        this.bookRepository.deleteBook(book);
    }
}
