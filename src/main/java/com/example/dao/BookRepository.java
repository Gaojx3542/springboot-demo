package com.example.dao;

import com.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Gaojx
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);

    List<Book> findByNameContaining(String name);

}
