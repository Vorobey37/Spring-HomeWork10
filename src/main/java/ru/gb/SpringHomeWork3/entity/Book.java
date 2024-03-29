package ru.gb.SpringHomeWork3.entity;

import lombok.Data;

@Data
public class Book {

    private static long genId;


    private final long id;


    private final String name;

    public Book(String name) {
        this.name = name;
        id = genId++;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String bookName(){
        return name;
    }
}
