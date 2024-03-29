package ru.gb.SpringHomeWork3.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import ru.gb.SpringHomeWork3.entity.Issue;
import ru.gb.SpringHomeWork3.entity.Reader;
import ru.gb.SpringHomeWork3.entity.ReaderEntity;
import ru.gb.SpringHomeWork3.services.DataBaseReaderService;
import ru.gb.SpringHomeWork3.services.ReaderService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    private final DataBaseReaderService dataBaseReaderService;



    @GetMapping()
    public List<Reader> getAllReaders(){
        return readerService.getAllReaders();
    }

    @GetMapping("/{id}")
    public Reader getById(@PathVariable long id){
        return readerService.getReaderById(id);
    }

    @PostMapping()
    public void addReader(@RequestBody Reader reader){
        readerService.addReader(reader);
    }

    @DeleteMapping("/{id}")
    public void deleteReader(@PathVariable long id){
        readerService.deleteReader(id);
    }

    @GetMapping("/{id}/issue")
    public List<Issue> getAllIssuesForIdReader(@PathVariable long id){
        List<Issue> issues = new ArrayList<>();

        for (Issue issue : readerService.getAllIssues()) {
            if (issue.getIdReader() == id){
                issues.add(issue);
            }
        }

        return issues;
    }

    @GetMapping("/database")
    public List<ReaderEntity> getAllReadersFromDataBase(){
        return dataBaseReaderService.getAllReadersFromDataBase();
    }

    @GetMapping("/database/{id}")
    public ReaderEntity getReaderByIdFromDataBase(@PathVariable long id){
        return dataBaseReaderService.getReaderByIdFromDataBase(id);
    }

}
