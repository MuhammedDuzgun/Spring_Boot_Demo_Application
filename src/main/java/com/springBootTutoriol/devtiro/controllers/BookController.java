package com.springBootTutoriol.devtiro.controllers;

import com.springBootTutoriol.devtiro.entites.Book;
import com.springBootTutoriol.devtiro.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return this.bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return this.bookService.getBookById(id);
    }

    @PostMapping("/add-book")
    public void addBook(@RequestBody Book book) {
        this.bookService.addBook(book);
    }

    @PostMapping("/update-book")
    public void updateBook(@RequestBody Book book) {
        this.bookService.updateBook(book);
    }

    @DeleteMapping("/delete-book")
    public void deleteBook(@RequestBody Book book) {
        this.bookService.deleteBook(book);
    }

}
