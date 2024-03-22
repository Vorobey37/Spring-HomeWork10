package ru.gb.SpringHomeWork3.repository;

import org.springframework.stereotype.Repository;

import ru.gb.SpringHomeWork3.entity.Reader;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReaderRepository {
    private List<Reader> readerList = new ArrayList<>();

    public ReaderRepository() {
        readerList.add(new Reader("Костя"));
        readerList.add(new Reader("Лёха"));
        readerList.add(new Reader("Танюшка"));
    }

    public Reader findById(long id){
        return readerList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Reader> getReaderList() {
        return readerList;
    }

    public void addReader(Reader reader){
        readerList.add(reader);
    }

    public void deleteReader(long id){
        readerList.remove(findById(id));
    }
}
