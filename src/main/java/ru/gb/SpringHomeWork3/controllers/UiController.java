package ru.gb.SpringHomeWork3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.gb.SpringHomeWork3.entity.Issue;
import ru.gb.SpringHomeWork3.services.UiService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui")
public class UiController {
    private final UiService uiService;

    public UiController(UiService uiService) {
        this.uiService = uiService;
    }

    @GetMapping("books")
    public String getAllBooks(Model model){

        List<String> bookList = new ArrayList<>();

        if (uiService.getAllBooks().isEmpty()){
            bookList.add("Читатели отсутствуют!");
        }

        for (int i = 0; i < uiService.getAllBooks().size(); i++) {
            bookList.add("Книга N" + (i + 1) + ": " + uiService.getAllBooks().get(i));
        }

        model.addAttribute("bookList", bookList);
        return "books";
    }

    @GetMapping("readers")
    public String getAllReaders(Model model){

        List<String> readerList = new ArrayList<>();

        if (uiService.getAllReaders().isEmpty()){
            readerList.add("Читатели отсутствуют!");
        }

        for (int i = 0; i < uiService.getAllReaders().size(); i++) {
            readerList.add("Книга N" + (i + 1) + ": " + uiService.getAllReaders().get(i));
        }

        model.addAttribute("readerList", readerList);
        return "readers";
    }

    @GetMapping("issues")
    public String getAllIssues(Model model){

        List<Issue> issueList = uiService.getAllIssues();
        model.addAttribute("table", issueList);

        return "issues";
    }

    @GetMapping("readers/{id}")
    public String getReaderById(@PathVariable long id, Model model){

        model.addAttribute("id", uiService.getReaderById(id));

        return "reader";
    }


}
