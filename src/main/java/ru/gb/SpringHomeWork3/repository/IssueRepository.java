package ru.gb.SpringHomeWork3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.SpringHomeWork3.entity.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {
    private List<Issue> issueList = new ArrayList<>();

    public void createIssue(Issue issue){
        issueList.add(issue);
    }

    public Issue findById(long id){
        return issueList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Issue> getIssueList() {
        return issueList;
    }
}
