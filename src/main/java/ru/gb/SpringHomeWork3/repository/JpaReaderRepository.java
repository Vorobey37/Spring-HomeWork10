package ru.gb.SpringHomeWork3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.SpringHomeWork3.entity.ReaderEntity;

public interface JpaReaderRepository extends JpaRepository<ReaderEntity, Long> {

}
