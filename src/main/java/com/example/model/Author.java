package com.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Gaojx
 */
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authors",fetch = FetchType.EAGER)
    private Set<Book> books;

    public Author() {
        super();
    }

    public Author(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books.size() +
                '}';
    }
}
