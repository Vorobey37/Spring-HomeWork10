package ru.gb.SpringHomeWork3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.gb.SpringHomeWork3.entity.IssueEntity;

import ru.gb.SpringHomeWork3.repository.JpaIssueRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataBaseIssueService {

    private final JpaIssueRepository jpaIssueRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void onCreateDataBase(){

        jpaIssueRepository.save(new IssueEntity(1, 0));
        jpaIssueRepository.save(new IssueEntity(0, 1));
        jpaIssueRepository.save(new IssueEntity(2, 2));
    }

    public List<IssueEntity> getAllEntitiesFromDataBase(){
        return jpaIssueRepository.findAll();
    }

    public IssueEntity getIssueByIdFromDataService(long id){
        return jpaIssueRepository.findById(id).orElse(null);
    }

}
