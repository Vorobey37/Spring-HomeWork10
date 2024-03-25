package ru.gb.SpringHomeWork3.services;

import org.springframework.stereotype.Service;
import ru.gb.SpringHomeWork3.controllers.IssueRequest;
import ru.gb.SpringHomeWork3.entity.Issue;
import ru.gb.SpringHomeWork3.repository.BookRepository;
import ru.gb.SpringHomeWork3.repository.IssueRepository;
import ru.gb.SpringHomeWork3.repository.ReaderRepository;

import java.util.NoSuchElementException;

@Service
public class IssueService {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public IssueService(BookRepository bookRepository, ReaderRepository readerRepository, IssueRepository issueRepository) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
        this.issueRepository = issueRepository;
    }

    public Issue createIssue(IssueRequest issueRequest){

        if (bookRepository.findById(issueRequest.getBookId()) == null){

            throw new NoSuchElementException("Не удалось найти книгу с id = " + issueRequest.getBookId());

        }
        if (readerRepository.findById(issueRequest.getReaderId()) == null){

            throw new NoSuchElementException("Не удалось найти читателя с id = " + issueRequest.getReaderId());
        }
        if (readerRepository.findById(issueRequest.getReaderId()).isBook()){

            throw new RuntimeException("У читателя с id = " + issueRequest.getReaderId() + " уже есть книга");
        }

        Issue issue = new Issue(issueRequest.getReaderId(), issueRequest.getBookId());
        readerRepository.findById(issueRequest.getReaderId()).setBook(true);
        issueRepository.createIssue(issue);

        return issue;
    }

    public void returnBook(long idBook){
        issueRepository.returnBook(idBook);

    }

    public Issue getIssueById(long id){
        return issueRepository.findById(id);
    }


}
