package com.example.dao;

import com.example.model.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gaojx
 */
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {

    BookDetail findByNumberOfPages(Integer numberOfPages);
}
