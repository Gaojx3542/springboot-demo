package com.example.repository;

import com.example.dao.BookDetailRepository;
import com.example.dao.BookRepository;
import com.example.model.Book;
import com.example.model.BookDetail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author Gaojx
 */
@SpringBootTest
public class OnetooneApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookDetailRepository bookDetailRepository;


    @BeforeEach
    public void init() {
        Book bookA = new Book("Spring in Action", new BookDetail(208));
        Book bookB = new Book("Spring Data in Action", new BookDetail(235));
        Book bookC = new Book("Spring Boot in Action");
        bookRepository.saveAll(Arrays.asList(bookA, bookB, bookC));
    }

    @AfterEach
    public void clear() {
        bookRepository.deleteAll();
    }

    @Test
    public void find() {
        Book book = bookRepository.findByName("Spring in Action");
        System.err.println(book.toString());
    }

    @Test
    public void save() {
        Book book = new Book("springboot");
        BookDetail bookDetail = new BookDetail(124);
        book.setBookDetail(bookDetail);
        bookRepository.save(book);
    }

    @Test
    public void delete() {

        bookRepository.deleteById(31L);
    }
    @Test
    public void findbook(){
        BookDetail bd = bookDetailRepository.findByNumberOfPages(235);
        System.err.println(bd.toString());




    }

}
