package com.codegym.c0821g1.service;

import com.codegym.c0821g1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IBlogService {

    List<Blog> getAll();

    List<Blog> findAll();

    List<Blog> findByName(String name);

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(int id);

    Page<Blog> findAll(PageRequest of);
}
