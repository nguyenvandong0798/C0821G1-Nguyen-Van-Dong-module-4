package com.codegym.c0821g1.service;

import com.codegym.c0821g1.model.Blog;
import com.codegym.c0821g1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();

    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(int id);

    Page<Category> findAll(PageRequest of);

    List<Category> findByName(String name);
}
