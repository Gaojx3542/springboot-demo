package com.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Gaojx
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    private Long id;

    private String name;


    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="detailId",referencedColumnName = "id")
    private BookDetail bookDetail;


    @ManyToOne
    @JoinColumn(name = "publishId", referencedColumnName = "id")
    private Publisher publisher;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "BOOK_AUTHOR", joinColumns = {
            @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
            @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")})
    private Set<Author> authors;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookDetail getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Book(){
        super();
    }
    public Book(String name){
        super();
        this.name =name;
    }

    public Book(String name, BookDetail bookDetail) {
        super();
        this.name = name;
        this.bookDetail = bookDetail;
    }
    @Override
    public String toString() {
//        System.out.println("publisher=" + publisher.getName());
//        System.out.println( "authors=" + authors.size());
        if (null == bookDetail) {
            return String.format("Book [id=%s, name=%s, number of pages=%s]", id, name, "<EMPTY>");
        }

        return String.format("Book [id=%s, name=%s, number of pages=%s]", id, name, bookDetail.getNumberOfPages());
    }
}
