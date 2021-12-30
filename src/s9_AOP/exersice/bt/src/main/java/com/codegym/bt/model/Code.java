package com.codegym.bt.model;

import javax.persistence.*;

@Entity(name = "code")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private Integer codee;

    @ManyToOne()
    @JoinColumn(name = "code_id")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Code() {
    }

    public Code(Integer id, Integer code) {
        this.id = id;
        this.codee = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodee() {
        return codee;
    }

    public void setCodee(Integer codee) {
        this.codee = codee;
    }

}
