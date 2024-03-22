package ru.gb.SpringHomeWork3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.SpringHomeWork3.entity.Book;


import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> bookList = new ArrayList<>();

    public BookRepository() {
        bookList.add(new Book("Война и мир"));
        bookList.add(new Book("Мастер и Маргарита"));
        bookList.add(new Book("Приключения Буратино"));
    }

    public Book findById(long id){
        return bookList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public void deleteBook(long id){
        bookList.remove(findById(id));
    }
}
