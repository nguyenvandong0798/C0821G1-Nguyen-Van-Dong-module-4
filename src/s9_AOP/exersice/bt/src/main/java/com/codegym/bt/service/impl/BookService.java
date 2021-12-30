package com.codegym.bt.service.impl;

import com.codegym.bt.model.Book;
import com.codegym.bt.model.Code;
import com.codegym.bt.repository.IBookRepository;
import com.codegym.bt.service.IBookService;
import com.codegym.bt.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service(value = "bookService")
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Autowired
    private ICodeService iCodeService;

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

    @Override
    public Book findByIdDecrease(Integer id) {
        Book book = iBookRepository.findById(id).orElse(null);
        book.setQuantity(book.getQuantity()-1);
        return book;
    }

    @Override
    public Book findByIdIncrease(Integer id) {
        Book book = iBookRepository.findById(id).orElse(null);
        book.setQuantity(book.getQuantity()+1);
        return book;
    }

    @Override
    public Code random(Book book) {
        Code code = new Code();
        int ramDom = (int) (Math.random() * 100000);
        code.setCodee(ramDom);
        code.setId(book.getId());
        code.setBook(book);
        iCodeService.save(code);
        return code;
    }
}
