package com.codegym.bt.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private String year;

    @Column(name = "quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private Set<Code> codes;

    public Set<Code> getCodes() {
        return codes;
    }

    public void setCodes(Set<Code> codes) {
        this.codes = codes;
    }

    public Book() {
    }

    public Book(int id, String name, String year, Integer quantity, Set<Code> codes) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.quantity = quantity;
        this.codes = codes;
    }

    public Book(int id, String title, String year, Integer quantity) {
        this.id = id;
        this.name = title;
        this.year = year;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
