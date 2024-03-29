package ru.gb.SpringHomeWork3.repository;

import org.springframework.data.repository.CrudRepository;

import ru.gb.SpringHomeWork3.entity.BookEntity;

public interface CrudBookRepository extends CrudRepository<BookEntity, Long> {
}
