package com.codegym.bt.service;


import com.codegym.bt.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {


    List<Blog> getAll();

    Blog findById(Integer id);

    void save(Blog blog);

    List<Blog> findByName(String name);

    void remove(Integer id);

    Page<Blog> findAll(Pageable of);
}