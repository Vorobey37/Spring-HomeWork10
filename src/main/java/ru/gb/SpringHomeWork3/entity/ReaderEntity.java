package ru.gb.SpringHomeWork3.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "readers")
@NoArgsConstructor
public class ReaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_book")
    private boolean isBook;

    @Column(name = "book_list")
    private String bookStringList;

    public ReaderEntity(String name) {
        this.name = name;
    }
}
