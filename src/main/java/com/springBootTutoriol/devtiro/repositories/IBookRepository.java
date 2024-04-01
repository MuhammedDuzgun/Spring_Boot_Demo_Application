package com.springBootTutoriol.devtiro.repositories;

import com.springBootTutoriol.devtiro.entites.Book;

import java.util.List;

public interface IBookRepository {

    List<Book> getBooks();

    Book getBookById(int id);

    void addBook(Book book);

    void updateBook(Book book);

    void updateBookTitle(Book book);

    void deleteBook(Book book);

}
