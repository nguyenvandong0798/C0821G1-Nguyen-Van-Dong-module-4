package com.codegym.bt.service;

import com.codegym.bt.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();

    List<Book> findAll();

    List<Book> findByName(String name);

    Book findById(Integer id);

    void save(Book book);

    void remove(int id);
}
