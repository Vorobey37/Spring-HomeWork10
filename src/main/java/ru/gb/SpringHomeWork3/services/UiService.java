package ru.gb.SpringHomeWork3.services;

import org.springframework.stereotype.Service;
import ru.gb.SpringHomeWork3.annotations.Time;
import ru.gb.SpringHomeWork3.entity.Book;
import ru.gb.SpringHomeWork3.entity.Issue;
import ru.gb.SpringHomeWork3.entity.Reader;
import ru.gb.SpringHomeWork3.repository.BookRepository;
import ru.gb.SpringHomeWork3.repository.IssueRepository;
import ru.gb.SpringHomeWork3.repository.ReaderRepository;

import java.util.List;

@Service
@Time
public class UiService {
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;

    public UiService(ReaderRepository readerRepository, BookRepository bookRepository, IssueRepository issueRepository) throws InterruptedException {
        this.readerRepository = readerRepository;
        this.bookRepository = bookRepository;
        this.issueRepository = issueRepository;
        //Thread.sleep(10000L);
        issueRepository.returnBook(2);
        //Thread.sleep(10000L);
        issueRepository.returnBook(0);
    }

    public List<Book> getAllBooks() throws InterruptedException {
        Thread.sleep(2000L);
        return bookRepository.getBookList();
    }

    public List<Reader> getAllReaders(){
        return readerRepository.getReaderList();
    }

    public List<Issue> getAllIssues(){
        return issueRepository.getIssueList();
    }

    public Reader getReaderById(long id){
        return readerRepository.findById(id);
    }
}
