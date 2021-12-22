package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> getAll();

    Blog findById(Integer id);

    void save(Blog blog);

    List<Blog> findByName(String name);
}
