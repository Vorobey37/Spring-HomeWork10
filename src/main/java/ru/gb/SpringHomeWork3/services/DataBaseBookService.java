package ru.gb.SpringHomeWork3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import ru.gb.SpringHomeWork3.entity.BookEntity;
import ru.gb.SpringHomeWork3.repository.CrudBookRepository;
import ru.gb.SpringHomeWork3.repository.JpaBookRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DataBaseBookService {

    private final CrudBookRepository crudBookRepository;
    private final JpaBookRepository jpaBookRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onCreateDataBase(){

        crudBookRepository.save(new BookEntity("Пираты Карибского моря"));
        crudBookRepository.save(new BookEntity("Огненные стрелы"));
        crudBookRepository.save(new BookEntity("Песня льда и пламени"));
    }

    public List<BookEntity> getAllBookFromDataBase(){
        Iterable<BookEntity> bookIterable = crudBookRepository.findAll();
        return StreamSupport.stream(bookIterable.spliterator(), false).toList();
    }

    public BookEntity getBookByIdFromDataBase(long id){
        return jpaBookRepository.findById(id).orElse(null);
    }
}
