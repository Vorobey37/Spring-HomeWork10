package ru.gb.SpringHomeWork3.controllers;

import lombok.Data;

@Data
public class IssueRequest {
    private long bookId;
    private long readerId;

    public IssueRequest(long bookId, long readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
    }

    public long getBookId() {
        return bookId;
    }

    public long getReaderId() {
        return readerId;
    }
}
