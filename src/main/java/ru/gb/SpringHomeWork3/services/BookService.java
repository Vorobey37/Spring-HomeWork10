package ru.gb.SpringHomeWork3.services;

import org.springframework.stereotype.Service;
import ru.gb.SpringHomeWork3.entity.Book;
import ru.gb.SpringHomeWork3.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.getBookList();
    }

    public Book getBookById(long id){
        return bookRepository.findById(id);
    }

    public Book addBook(Book book){
        bookRepository.addBook(book);
        return book;
    }

    public void deleteBook(long id){
        bookRepository.deleteBook(id);
    }
}
