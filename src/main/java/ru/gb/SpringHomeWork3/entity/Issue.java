package ru.gb.SpringHomeWork3.entity;

import lombok.Data;

@Data
public class Issue {
    private static long genId;
    private final long id;
    private final long idReader;
    private final long idBook;

    public Issue(long idReader, long idBook) {
        this.idReader = idReader;
        this.idBook = idBook;
        this.id = genId++;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", idReader=" + idReader +
                ", idBook=" + idBook +
                '}';
    }

    public long getIdReader() {
        return idReader;
    }
}
