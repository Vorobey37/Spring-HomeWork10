package ru.gb.SpringHomeWork3.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.SpringHomeWork3.entity.Book;
import ru.gb.SpringHomeWork3.entity.BookEntity;
import ru.gb.SpringHomeWork3.repository.BookRepository;
import ru.gb.SpringHomeWork3.repository.JpaBookRepository;
import ru.gb.SpringHomeWork3.services.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class BookControllerTest {

    @Autowired
    WebTestClient webTestClient;
    @Autowired
    JpaBookRepository JpaBookRepository;
    @Autowired
    BookController bookController;
    @MockBean
    BookRepository bookRepository;
    private List<Book> books;

    @BeforeEach
    void setUp() {
        books = new ArrayList<>();
        books.add(new Book("Книга 1"));
        books.add(new Book("Книга 2"));
        books.add(new Book("Книга 3"));

        List<BookEntity> books = JpaBookRepository.saveAll(
                List.of(
                        new BookEntity("Книга 1"),
                        new BookEntity("Книга 2"),
                        new BookEntity("Книга 3")
                )
        );

    }

    @Test
    void testGetAllBooks() {
        Mockito.doReturn(books).when(bookRepository).getBookList();
        Assertions.assertEquals(3, bookController.getAllBooks().size());
        Assertions.assertEquals("Книга 2", bookController.getAllBooks().get(1).getName());
    }

    @Test
    void testGetById() {
        Mockito.when(bookRepository.findById(2)).thenReturn(books.get(2));
        Assertions.assertEquals("Книга 3", bookController.getById(2).getName());
        Assertions.assertEquals(books.get(0).getId(), bookController.getById(0).getId());
    }

    @Test
    void testAddBook() {
        //не понятно, как метод void проверить

    }

    @Test
    void testDeleteBook() {
        //не понятно, как метод void проверить
    }

    @Test
    void testGetAllBooksFromDataBase() {

        List<BookEntity> responseBody = webTestClient.get()
                .uri("/database")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<BookEntity>>() {})
                .returnResult()
                .getResponseBody();

        Assertions.assertEquals(books.size(), responseBody.size());
        Assertions.assertEquals(books.get(2).getName(), responseBody.get(2).getName());

    }

    @Test
    void testGetByIdFromDataBase() {

        BookEntity responseBody = webTestClient.get()
                .uri("/database/2")
                .exchange()
                .expectBody(BookEntity.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertEquals(books.get(2).getName(), responseBody.getName());
    }
}