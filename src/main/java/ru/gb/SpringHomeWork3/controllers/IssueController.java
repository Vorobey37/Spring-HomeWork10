package ru.gb.SpringHomeWork3.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.gb.SpringHomeWork3.entity.Issue;
import ru.gb.SpringHomeWork3.entity.IssueEntity;
import ru.gb.SpringHomeWork3.entity.Reader;
import ru.gb.SpringHomeWork3.services.DataBaseIssueService;
import ru.gb.SpringHomeWork3.services.IssueService;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("issue")
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;
    private final DataBaseIssueService dataBaseIssueService;


    @PostMapping()
    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest issueRequest){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(issueService.createIssue(issueRequest));

        } catch (NoSuchElementException exception){
            return ResponseEntity.notFound().build();
        } catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    @GetMapping("/{id}")
    public Issue getById(@PathVariable long id){
        return issueService.getIssueById(id);
    }

    @GetMapping("/database")
    public List<IssueEntity> getByIdFromDataBase(){
        return dataBaseIssueService.getAllEntitiesFromDataBase();
    }

    @GetMapping("/database/{id}")
    public IssueEntity getIssueByIdFromDataBase(@PathVariable long id){
        return dataBaseIssueService.getIssueByIdFromDataService(id);
    }


}
