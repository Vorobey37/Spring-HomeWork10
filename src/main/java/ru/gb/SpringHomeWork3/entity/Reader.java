package ru.gb.SpringHomeWork3.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Reader {
    private static long genId;
    private final long id;
    private final String name;
    private boolean isBook;
    private final List<Book> bookList = new ArrayList<>();

    public Reader(String name) {
        this.name = name;
        id = genId++;
        isBook = false;
    }

    public long getId() {
        return id;
    }

    public boolean isBook() {
        return isBook;
    }

    public void setBook(boolean book) {
        isBook = book;
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public String getReaderAndHisBooks(){
        List<String> books = new ArrayList<>();
        for (Book book : bookList) {
            books.add(book.bookName());
        }
        return name + " взял следующие книги: " + books;
    }
}
