package com.codegym.bt.service;

import com.codegym.bt.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    void remove(Integer id);

    void save(Category category);

    Page<Category> findAllPage(PageRequest of);

    List<Category> findByName(String name);

}