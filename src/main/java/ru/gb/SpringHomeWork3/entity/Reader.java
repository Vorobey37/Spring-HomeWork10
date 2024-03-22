package ru.gb.SpringHomeWork3.entity;

import lombok.Data;

@Data
public class Reader {
    private static long genId;
    private final long id;
    private final String name;
    private boolean isBook;

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
}
