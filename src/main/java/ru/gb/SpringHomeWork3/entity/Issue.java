package ru.gb.SpringHomeWork3.entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

//@Entity
@Data
public class Issue {
    private static long genId;
    private final long id;
    private final long idReader;
    private final long idBook;

    private Date getDate;
    private Date returnDate;

    public Issue(long idReader, long idBook) {
        this.idReader = idReader;
        this.idBook = idBook;
        this.getDate = new Date();
        this.id = genId++;
    }

    public long getId() {
        return id;
    }


    public long getIdReader() {
        return idReader;
    }


    public long getIdBook() {
        return idBook;
    }

    public Date getGetDate() {
        return getDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
