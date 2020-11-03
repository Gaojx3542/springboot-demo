package com.example.repository;

import com.example.dao.BookRepository;
import com.example.dao.PublisherRepository;
import com.example.model.Book;
import com.example.model.Publisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Gaojx
 */
@SpringBootTest
public class OnetomanyApplicationTests {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void init() {

        Book book1 = new Book("spring");
        Book book2 = new Book("mvc");
        Book book3 = new Book("mybatis");
        Publisher publisher = new Publisher("zhonghua");
        Set<Book> set = new HashSet<Book>();
        set.add(book1);
        set.add(book2);
        set.add(book3);
        publisher.setBooks(set);
        publisherRepository.save(publisher);

    }

    @AfterEach
    public void clear() {
        publisherRepository.deleteAll();
    }

    @Test
    public void find() {
        Publisher publisher = publisherRepository.findByName("zhonghua");
        System.out.println(publisher);
    }

    @Test
    public void find2() {
        Book book = bookRepository.findByName("mvc");
        System.out.println(book);
    }
}
