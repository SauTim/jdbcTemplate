package ru.tim.springjdbc.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_year")
    private Long birthYear;

    @OneToMany(mappedBy = "person")
    private List<Book> books;

    public Person() {
    }

    public Person(String fullName, Long birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setPerson(this);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
        book.setPerson(null);
    }
}
