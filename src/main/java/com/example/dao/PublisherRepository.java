package com.example.dao;

import com.example.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gaojx
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findByName(String name);
}
