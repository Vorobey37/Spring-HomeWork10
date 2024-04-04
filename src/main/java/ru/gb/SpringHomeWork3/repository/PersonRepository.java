package ru.gb.SpringHomeWork3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.SpringHomeWork3.entity.Person;

import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByLogin(String login);

}
