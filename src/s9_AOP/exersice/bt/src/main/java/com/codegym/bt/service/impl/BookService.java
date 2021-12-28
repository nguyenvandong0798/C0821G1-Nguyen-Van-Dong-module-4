package com.codegym.bt.service.impl;

import com.codegym.bt.model.Book;
import com.codegym.bt.repository.IBookRepository;
import com.codegym.bt.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bookService")
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public List<Book> getAll() {
        return iBookRepository.findAll();
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public List<Book> findByName(String name) {
        return iBookRepository.getByName("%"+name+"%");
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void remove(int id) {
        Book book = iBookRepository.getById(id);
        iBookRepository.delete(book);
    }
}
