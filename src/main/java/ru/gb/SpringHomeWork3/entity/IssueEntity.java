package ru.gb.SpringHomeWork3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "issues")
@NoArgsConstructor
public class IssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_reader")
    private long idReader;

    @Column(name = "id_book")
    private long idBook;

    @Column(name = "get_date")
    private String getDate;

    @Column(name = "return_Date")
    private String returnDate;

    public IssueEntity(long idReader, long idBook) {
        this.idReader = idReader;
        this.idBook = idBook;
        this.getDate = (new Date()).toString();
    }
}
