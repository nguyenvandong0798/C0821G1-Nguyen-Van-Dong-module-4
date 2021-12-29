package com.codegym.bt.model;

import javax.persistence.*;

@Entity(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private String year;

    @Column(name = "quantity")
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "code_id")
    private Code code;

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Book() {
    }

    public Book(int id, String name, String year, String quantity, Code code) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.quantity = quantity;
        this.code = code;
    }

    public Book(int id, String title, String year, String quantity) {
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
