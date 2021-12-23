package com.codegym.c0821g1.service;

import com.codegym.c0821g1.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> getAll();

    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(int id);
}
