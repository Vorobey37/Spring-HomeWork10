package ru.gb.SpringHomeWork3.services;

import lombok.RequiredArgsConstructor;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.gb.SpringHomeWork3.entity.Person;
import ru.gb.SpringHomeWork3.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public Person findByLogin(String login){
        return personRepository.findByLogin(login).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь с login " + login + " отсутствует!")
        );
    }

    @EventListener(ContextRefreshedEvent.class)
    private void createStartData(){

        Person admin = new Person();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setRole("admin");

        Person user = new Person();
        user.setLogin("user");
        user.setPassword("user");
        user.setRole("user");

        createPerson(admin);
        createPerson(user);
    }
}
