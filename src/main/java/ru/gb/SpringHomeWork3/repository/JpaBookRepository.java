package ru.gb.SpringHomeWork3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.gb.SpringHomeWork3.entity.BookEntity;

public interface JpaBookRepository extends JpaRepository<BookEntity, Long> {
}
