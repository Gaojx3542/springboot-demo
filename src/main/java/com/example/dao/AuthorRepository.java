package com.example.dao;

import com.example.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Gaojx
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByName(String name);

    List<Author> findByNameContaining(String name);
}
