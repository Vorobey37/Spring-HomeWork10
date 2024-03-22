package ru.gb.SpringHomeWork3.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.gb.SpringHomeWork3.entity.Issue;
import ru.gb.SpringHomeWork3.entity.Reader;
import ru.gb.SpringHomeWork3.services.IssueService;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("issue")
public class IssueController {
    private IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

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



    public IssueService getIssueService() {
        return issueService;
    }
}
