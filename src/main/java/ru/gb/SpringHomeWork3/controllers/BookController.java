package ru.gb.SpringHomeWork3.controllers;

import org.springframework.web.bind.annotation.*;
import ru.gb.SpringHomeWork3.entity.Book;
import ru.gb.SpringHomeWork3.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable long id){
        return bookService.getBookById(id);
    }

    @PostMapping()
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
    }
}
