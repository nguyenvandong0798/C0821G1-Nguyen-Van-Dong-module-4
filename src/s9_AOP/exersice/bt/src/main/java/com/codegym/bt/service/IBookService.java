package com.codegym.bt.service;

import com.codegym.bt.model.Book;
import com.codegym.bt.model.Code;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    List<Book> findAll();

    List<Book> findByName(String name);

    Book findById(Integer id);

    void save(Book book);

    void remove(int id);

    Book findByIdDecrease(Integer id);

    Book findByIdIncrease(Integer id);

    Code random(Book book);

}
