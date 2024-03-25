package ru.gb.SpringHomeWork3.controllers;

import org.springframework.web.bind.annotation.*;

import ru.gb.SpringHomeWork3.entity.Issue;
import ru.gb.SpringHomeWork3.entity.Reader;
import ru.gb.SpringHomeWork3.services.ReaderService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reader")
public class ReaderController {
    private ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

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
}
