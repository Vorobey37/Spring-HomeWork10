package ru.gb.SpringHomeWork3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.gb.SpringHomeWork3.entity.ReaderEntity;
import ru.gb.SpringHomeWork3.repository.JpaReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataBaseReaderService {

    private final JpaReaderRepository jpaReaderRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onCreateDataBase(){

        jpaReaderRepository.save(new ReaderEntity("Максик"));
        jpaReaderRepository.save(new ReaderEntity("Никитос"));
        jpaReaderRepository.save(new ReaderEntity("Мишаня"));
    }

    public List<ReaderEntity> getAllReadersFromDataBase(){
        return jpaReaderRepository.findAll();
    }

    public ReaderEntity getReaderByIdFromDataBase(long id){
        return jpaReaderRepository.findById(id).orElse(null);
    }
}
