package ru.gb.SpringHomeWork3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.SpringHomeWork3.entity.Issue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class IssueRepository {
    private final List<Issue> issueList = new ArrayList<>();
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;

    public IssueRepository(ReaderRepository readerRepository, BookRepository bookRepository) {
        this.readerRepository = readerRepository;
        this.bookRepository = bookRepository;
        createIssue(new Issue(0, 1));
        readerRepository.findById(0).addBook(bookRepository.findById(1));
        createIssue(new Issue(1, 0));
        readerRepository.findById(1).addBook(bookRepository.findById(0));
        createIssue(new Issue(2, 2));
        readerRepository.findById(2).addBook(bookRepository.findById(2));
    }

    public void createIssue(Issue issue){
        issueList.add(issue);
    }

    public Issue findById(long id){
        return issueList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void returnBook(long idBook){
        for (Issue issue : issueList) {
            if (issue.getIdBook() == idBook && issue.getReturnDate() == null){
                issue.setReturnDate(new Date());
            }
        }
    }

    public List<Issue> getIssueList() {
        return issueList;
    }
}
