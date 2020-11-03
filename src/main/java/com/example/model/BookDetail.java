package com.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Gaojx
 */
@Entity
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "persistenceGenerator", strategy = "increment")
    private Long id;

    @Column(name = "NUMBER_OF_PAGES")
    private Integer numberOfPages;

    @OneToOne(mappedBy = "bookDetail")
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookDetail() {
        super();
    }

    public BookDetail(Integer numberOfPages) {
        super();
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        if (null == book) {
            return String.format("Book [id=%s, name=%s, number of pages=%s]", id, "<EMPTY>");
        }

        return String.format("Book [id=%s, name=%s, number of pages=%s]", id,book.getId(),book.getName());
    }


}
